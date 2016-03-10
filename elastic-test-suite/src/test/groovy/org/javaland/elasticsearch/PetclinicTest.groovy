package org.javaland.elasticsearch

import groovy.util.logging.Slf4j
import org.elasticsearch.action.index.IndexResponse
import org.junit.Test

@Slf4j
public class PetclinicTest extends ElasticsearchTest {

  @Test
  public void createTest() {
    String source = '{ "user" : "Andrey", "post_date" : "2009-11-15T14:12:12" }'
    IndexResponse response = client.prepareIndex("petclinic", "vet", "1")
      .setSource(source)
      .get()
    response.getId()
  }

}
