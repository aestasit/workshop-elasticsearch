package org.javaland.elasticsearch

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest
import org.elasticsearch.client.Client
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.node.Node
import org.junit.AfterClass
import org.junit.BeforeClass

import static org.elasticsearch.node.NodeBuilder.nodeBuilder

@CompileStatic
@TypeChecked
abstract class ElasticsearchTest {

  private static final String HTTP_PORT = "9400"
  private static final String HTTP_TRANSPORT_PORT = "9500"

  private static Node node
  protected static Client client

  @BeforeClass
  public static void startElasticsearchServer() {
    Map<String, String> settingsMap = new HashMap<>()
    settingsMap.put("path.conf", "storage/elasticsearch")
    settingsMap.put("path.home", "/elasticsearch")
    settingsMap.put("path.data", "storage/elasticsearch")
    settingsMap.put("path.work", "storage/elasticsearch")
    settingsMap.put("path.logs", "storage/elasticsearch")
    settingsMap.put("http.port", HTTP_PORT)
    settingsMap.put("transport.tcp.port", HTTP_TRANSPORT_PORT)
    settingsMap.put("index.number_of_shards", "1")
    settingsMap.put("index.number_of_replicas", "0")
    settingsMap.put("discovery.zen.ping.multicast.enabled", "false")
    settingsMap.put("action.auto_create_index", "true")
    settingsMap.put("index.mapper.dynamic", "true")
    Settings settings = Settings.settingsBuilder()
      .put(settingsMap).build()
    node = nodeBuilder().settings(settings).node()
    node.start()
    client = node.client()
  }

  @AfterClass
  public static void stopElasticsearchServer() {
    node.client().admin()
      .indices()
      .delete(new DeleteIndexRequest("petclinic"))
      .actionGet()
    node.close()
  }

}
