package org.apache.ibatis.jgamestore.persistence.iface;

public interface SequenceDao {

  int getNextId(String name);

}
