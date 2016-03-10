@echo off
@call env_logstash.bat
@call %LOGSTASH_HOME%\bin\rspec tests\client1_spec.rb
@call %LOGSTASH_HOME%\bin\rspec tests\client2_spec.rb