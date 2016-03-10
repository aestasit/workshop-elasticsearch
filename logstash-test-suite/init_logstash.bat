@echo off
@call env_logstash.bat
@call %LOGSTASH_HOME%\bin\plugin install --development