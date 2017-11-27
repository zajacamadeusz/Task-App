call runcrud.bat
if "%ERRORLEVEL%" == "0" goto gettasks
echo.
echo  RUNCRUD.BAT OPENING FAILED - breaking work
goto fail

:gettasks
start opera "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo  WEBSITE OPENING FAILED - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.