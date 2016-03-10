# encoding: utf-8

require "logstash/devutils/rspec/spec_helper"
require "logstash/filters/multiline"
require "logstash/filters/grok"
require "logstash/filters/date"
require "logstash/filters/mutate"

describe "logstash filters" do
           
  describe "client1 weblogic server" do
    config File.open("conf/14-client1-filters.conf", "rb").read
    sample File.open("samples/client1_weblogic1.log", { encoding: "UTF-8" } ).lines.
      map { |line| { "type" => "client1_weblogic", "message" => line } } do      
      # TODO: test record count
      subject.each_index do |i| 
        # TODO: test all fields
        puts "Severity: #{subject[i]["severity"]}"
        puts "Subsystem: #{subject[i]["subsystem"]}"
        puts "Machine: #{subject[i]["machine"]}"
        puts "Server: #{subject[i]["server"]}"
        puts "Thread: #{subject[i]["thread"]}"
        puts "User: #{subject[i]["user"]}"
        puts "Message ID: #{subject[i]["message_id"]}"
        puts "Diagnostic: #{subject[i]["diagnostic"]}"
        puts "Raw time: #{subject[i]["raw_time"]}"
        puts "Transaction: #{subject[i]["transaction"]}"
        puts "Message Text: #{subject[i]["message_text"]}"
        puts "Tags: #{subject[i]["tags"]}"
        puts "Timestamp: #{subject[i]["timestamp"]}"
      end
    end

  end

  describe "client1 weblogic access" do
    config File.open("conf/14-client1-filters.conf", "rb").read
    sample File.open("samples/client1_access1.log", { encoding: "UTF-8" } ).lines.
      map { |line| { "type" => "client1_access", "message" => line } } do      
      # TODO: test record count
      subject.each_index do |i| 
        # TODO: test all fields
        puts "IP: #{subject[i]["http_client_ip"]}"
        puts "Level: #{subject[i]["http_level"]}"
        puts "User: #{subject[i]["http_user"]}"
        puts "Method: #{subject[i]["http_method"]}"
        puts "Path: #{subject[i]["http_path"]}"
        puts "Protocol: #{subject[i]["http_protocol"]}"
        puts "Status: #{subject[i]["http_status"]}"
        puts "Size: #{subject[i]["http_response_size"]}"
        puts "Tags: #{subject[i]["tags"]}"
        puts "Timestamp: #{subject[i]["timestamp"]}"
      end
    end

  end

end