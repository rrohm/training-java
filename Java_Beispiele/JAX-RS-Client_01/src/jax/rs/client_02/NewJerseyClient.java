/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jax.rs.client_02;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:Event Search Service
 * [categories]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class NewJerseyClient {
  private WebTarget webTarget;
  private Client client;
  private static final String BASE_URI = "http://www.zvents.com/rest";

  public NewJerseyClient() {
    client = javax.ws.rs.client.ClientBuilder.newClient();
    webTarget = client.target(BASE_URI).path("categories");
  }

  /**
   * @param responseType Class representing the response
   * @param key query parameter[REQUIRED]
   * @return response object (instance of responseType class)
   */
  public <T> T getCategories(Class<T> responseType, String key) throws ClientErrorException {
    webTarget = webTarget.queryParam("key", key);
    return webTarget.request(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
  }

  public void close() {
    client.close();
  }
  
}
