/*
 */
package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import logik.statistik.Summe;

/**
 * REST Web Service
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@Path("generic")
public class GenericResource {

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of GenericResource
   */
  public GenericResource() {
  }

  /**
   * Nur Test:
   * @return
   */
  @GET
  @Path("data")
  @Produces("application/json")
  public Data getData() {
    return new Data();
  }

  /**
   * Statistische Auswertung: Summenberechnung
   * @param in
   * @return
   */
  @POST
  @Path("data")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Data getData(Data in) {    
    final Data data = new Data();
    data.setData(new int[]{Summe.berechne(in.getData())});
    return data;
  }
}
