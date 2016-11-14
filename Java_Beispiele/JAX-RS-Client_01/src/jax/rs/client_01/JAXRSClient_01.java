/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jax.rs.client_01;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.meins.rest.daten.Person;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class JAXRSClient_01 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {

      ClientConfig config = new ClientConfig();

      Client client = ClientBuilder.newClient(config);

      WebTarget target = client.target("http://localhost:8080/REST_01_JavaEE/webresources/");
      
      final String get = target.path("generic").path("personen").request()
              .accept(MediaType.APPLICATION_JSON).get(String.class);
      
      final java.util.List list = target.path("generic").path("personen").request()
              .accept(MediaType.APPLICATION_JSON).get(java.util.List.class);

      System.out.println(list);
      System.out.println(get);
      System.out.println(get
              .toString());

//      System.out.println(target.path("rest").path("hello").request()
//              .accept(MediaType.TEXT_PLAIN).get(Response.class)
//              .toString());
//      
//      System.out.println(target.path("rest").path("hello").request()
//              .accept(MediaType.TEXT_PLAIN).get(Response.class)
//              .toString());
//
//      System.out.println(target.path("rest").path("hello").request()
//              .accept(MediaType.TEXT_PLAIN).get(String.class));
//
//      System.out.println(target.path("rest").path("hello").request()
//              .accept(MediaType.TEXT_XML).get(String.class));
//
//      System.out.println(target.path("rest").path("hello").request()
//              .accept(MediaType.TEXT_HTML).get(String.class));

//
//      if (response.getStatus() != 200) {
//        throw new RuntimeException("Failed : HTTP error code : "
//                + response.getStatus());
//      }
//
//      String output = response.getEntity(String.class);

      System.out.println("Output from Server .... \n");
//      System.out.println(output);

    } catch (Exception e) {

      e.printStackTrace();

    }
  }

}
