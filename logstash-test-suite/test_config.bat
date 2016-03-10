@echo off
@call env_logstash.bat
@call %LOGSTASH_HOME%\bin\logstash agent --configtest --config conf\12-client1-inputs.conf
@call %LOGSTASH_HOME%\bin\logstash agent --configtest --config conf\12-client2-inputs.conf
@call %LOGSTASH_HOME%\bin\logstash agent --configtest --config conf\14-client1-filters.conf
@call %LOGSTASH_HOME%\bin\logstash agent --configtest --config conf\14-client2-filters.conf
