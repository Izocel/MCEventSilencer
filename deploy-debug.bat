set SERVER=C:\projects\Whitelist-DMC\server_test
set BUILDER=C:\projects\MCEventSilencer
set PLUGIN_FILTER=MCEventSilencer*shaded.jar


cd %BUILDER%
XCOPY target\%PLUGIN_FILTER% %SERVER%\plugins\ /S /Y

cd %SERVER%
START "Minecraft-Debug" launch_debug.bat

echo Job's done SERVER is awaiting debug socket connection...
