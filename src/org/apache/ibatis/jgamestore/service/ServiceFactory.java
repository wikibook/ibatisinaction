/*
 * Created on Feb 20, 2005
 *
 */
package org.apache.ibatis.jgamestore.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.ibatis.common.exception.NestedRuntimeException;
import com.ibatis.common.resources.Resources;

/**
 * @author Brandon Goodin
 *
 */
public class ServiceFactory {
  
  private static final String configLocation = "properties/ServiceImpls.properties";
  
  private static ServiceFactory instance;
  
  private Map implMap;
  
  private ServiceFactory() {
    
    InputStream is = null;
    
    try {
      
      is = Resources.getResourceAsStream(configLocation);
      
      if(is == null) {
        throw new RuntimeException(configLocation + " not found");
      }
      
      Properties properties = new Properties();
      properties.load(is);
      
      implMap = new HashMap(properties);
      
    } catch (IOException ex){
      throw new NestedRuntimeException(ex.getMessage(),ex);
    } finally {
      if(is != null) {
        try {
          is.close();
        } catch (IOException ex) {
          throw new NestedRuntimeException("Could not close property file input stream: " + ex.getMessage(),ex);
        }
      }
    }
  }
  
  public Object getService(Class clazz){
    
    String ifaceName = clazz.getName();
    String implName = (String)implMap.get(ifaceName);
    
    if(implName == null) {
      throw new RuntimeException(ifaceName + " was not defined in the ServiceImpls configuration file.");
    }
    
    Class implClass = null;
    Object impl = null;
    try {
      implClass = Class.forName(implName);
      impl = implClass.newInstance();
    } catch (ClassNotFoundException ex) {
      throw new NestedRuntimeException(ex.getMessage(),ex);
    } catch (InstantiationException ex ) {
      throw new NestedRuntimeException(ex.getMessage(),ex);
    } catch (IllegalAccessException ex) {
      throw new NestedRuntimeException(ex.getMessage(),ex);
    }
    
    return impl;
  }
  
  public static ServiceFactory getInstance() {
    if(instance == null) {
        instance = new ServiceFactory();
    }
    return instance;
  }
  
}
