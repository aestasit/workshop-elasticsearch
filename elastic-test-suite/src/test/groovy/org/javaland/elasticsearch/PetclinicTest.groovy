package org.javaland.elasticsearch

import groovy.util.logging.Slf4j
import org.elasticsearch.action.delete.DeleteResponse
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.action.update.UpdateResponse
import org.elasticsearch.client.transport.TransportClient
import org.junit.Test

@Slf4j
public class PetclinicTest extends ElasticsearchTest {

  @Test
  public void createTest() {
    String source = '{ "user" : "Andrey", "post_date" : "2009-11-15T14:12:12" }'
    IndexResponse response = client.prepareIndex("petclinic", "vet", "1")
      .setSource(source)
      .get()
    println response.getId()
  }

  @Test
  public void updateTest() {
    String source = '{ "user" : "Andrey", "post_date" : "2009-11-15T14:12:12" }'
    UpdateResponse response = client.prepareUpdate("petclinic", "vet", "1")
      .setDoc(source.bytes)
      .get()
    println response.getId()
  }


  @Test
  public void deleteTest() {
    String source = '{ "user" : "Andrey", "post_date" : "2009-11-15T14:12:12" }'
    DeleteResponse response = client.prepareDelete("petclinic", "vet", "1").get()
    println response.getId()
  }


}
