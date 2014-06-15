@echo off
setlocal

if not "%COMMAND_ARGS%" == "" goto :runAnt
set COMMAND_ARGS=-buildfile build.xml -propertyfile build.properties 

:runAnt
set BUILD_CP=%JAVA_HOME%\lib\tools.jar;
for %%j in (../devlib/*.jar) do call concat.bat %%j;

echo %JAVA_HOME%\bin\java -classpath %BUILD_CP% org.apache.tools.ant.Main %COMMAND_ARGS% %1
%JAVA_HOME%\bin\java -classpath %BUILD_CP% org.apache.tools.ant.Main %COMMAND_ARGS% %1

endlocal
set BUILD_CP=
set COMMAND_ARGS=