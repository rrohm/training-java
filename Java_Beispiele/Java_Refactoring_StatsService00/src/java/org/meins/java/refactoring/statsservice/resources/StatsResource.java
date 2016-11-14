/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 *
 *  You are free to:
 *
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 *
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 *
 *  Under the following terms:
 *
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 *
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 *
 *
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.refactoring.statsservice.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@Path("/stats")
public class StatsResource {

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of StatsResource
   */
  public StatsResource() {
  }

  @GET
  @Path("/avg")
  @Produces("application/json")
//  public List<Double> getAVG(){
//    List<Double> values = new ArrayList<>();
////    values.add(Double.NaN);
//    values.add(Double.MIN_VALUE);
//    values.add(Double.MAX_VALUE);
  public AVG getAVG(){
    return new AVG();
  }
//  public double[] getAVG(){
//    double[] values = {2.2, 3.3, 4.4};
//
//     return values;
//  }

  @POST
  @Path("avg")
  @Consumes("application/json")
  @Produces("application/json")
  public Double postAVG(List<Double> values){
    System.out.println("values: " + values);
     return 2.22222223;
  }

  public class AVG {
    private double value = 123.3;

    public double getValue() {
      return value;
    }

    public void setValue(double value) {
      this.value = value;
    }
  }
}
