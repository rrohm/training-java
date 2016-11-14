/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jax.rs.client_01;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.meins.rest.daten.Person;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class JAXRSClient_011 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    WebTarget webTarget;
    Client client;
    final String BASE_URI = "http://localhost:8080/REST_01_JavaEE/webresources/";

    client = javax.ws.rs.client.ClientBuilder.newClient();
    webTarget = client.target(BASE_URI).path("generic").path("personen");
    
    Response response = webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    System.out.println("response" + response);
    
    
    webTarget = client.target(BASE_URI).path("generic").path("person");
    Response responsePerson = webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
    
    System.out.println("responsePerson " + responsePerson);
    System.out.println("responsePerson " + responsePerson.readEntity(Person.class));
    
  }

}
