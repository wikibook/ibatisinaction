if [ -z "$COMMAND_ARGS"]; then
    # Assume a dev build by default
    COMMAND_ARGS="-buildfile build.xml -propertyfile build.properties"
fi

BUILD_CP=$JAVA_HOME/lib/tools.jar
for JAR in ../devlib/*.jar
do
    BUILD_CP=$BUILD_CP:$JAR
done

echo BUILD_CP:      $BUILD_CP
echo COMMAND_ARGS:  $COMMAND_ARGS
echo $JAVA_HOME/bin/java -classpath $BUILD_CP org.apache.tools.ant.Main $COMMAND_ARGS $1

$JAVA_HOME/bin/java -classpath $BUILD_CP org.apache.tools.ant.Main $COMMAND_ARGS $1

