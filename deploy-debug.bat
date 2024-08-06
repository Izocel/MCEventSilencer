set BUILDER=C:\projects\MCEventSilencer
set PLUGIN_FILTER=MCEventSilencer*shaded.jar

set SERVER_TYPE=Folia
set SERVERS_FOLDER=C:\projects\MinecraftsServers
set SERVER=%SERVERS_FOLDER%\%SERVER_TYPE%

cd %BUILDER%
XCOPY target\%PLUGIN_FILTER% %SERVER%\plugins\ /S /Y

cd %SERVER%
START "Minecraft-Debug" launch_debug.bat

echo Job's done SERVER is awaiting debug socket connection...
