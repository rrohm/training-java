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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.smells.grosseKlasse;

import java.util.List;

/**
 * "Bad Smell": Zu große Klasse.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DataService {

  public void saveCustomer(Object customer){
    // ...
  }

  public void deleteCustomer(Object customer){
    // ...
  }

  public Object getCustomer(long ID){
    // ...
    return null;
  }
  public List<Object> getAllCustomers(){
    // ...
    return null;
  }

  public void saveProduct(Object product){
    // ...
  }

  public void deleteProduct(Object product){
    // ...
  }

  public Object getProduct(long ID){
    // ...
    return null;
  }
  public List<Object> getAllProducts(){
    // ...
    return null;
  }

  public void saveOrder(Object order){
    // ...
  }

  public void deleteOrder(Object order){
    // ...
  }

  public Object getOrder(long ID){
    // ...
    return null;
  }
  public List<Object> getAllOrders(){
    // ...
    return null;
  }

  public void saveInvoice(Object invoice){
    // ...
  }

  public void deleteInvoice(Object invoice){
    // ...
  }

  public Object getInvoice(long ID){
    // ...
    return null;
  }
  public List<Object> getAllInvoices(){
    // ...
    return null;
  }
}
