call runcrud
if "%ERRORLEVEL%" == "0" goto openBrowser
echo.
echo Runcrud has errors
goto fail

:openBrowser
set url="http://localhost:8080/crud/v1/task/getTasks"
start chrome %url%
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.