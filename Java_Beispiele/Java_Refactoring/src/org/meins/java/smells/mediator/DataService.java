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
package org.meins.java.smells.mediator;

import java.util.List;

/**
 * "Bad Smell": Mediator - und zu große Klasse.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DataService {

  private CustomerAccess customerAccess;
  private ProductsAccess productsAccess;
  private OrdersAccess ordersAccess;
  private InvoiceAccess invoiceAccess;

  public void saveCustomer(Object customer){
    this.customerAccess.saveCustomer(customer);
  }

  public void deleteCustomer(Object customer){
    this.customerAccess.deleteCustomer(customer);
  }

  public Object getCustomer(long ID){
    return this.customerAccess.getCustomer(ID);
  }
  public List<Object> getAllCustomers(){
    return this.customerAccess.getAllCustomers();
  }

  public void saveProduct(Object product){
    this.productsAccess.saveProduct(product);
  }

  public void deleteProduct(Object product){
    this.productsAccess.deleteProduct(product);
  }

  public Object getProduct(long ID){
    return this.productsAccess.getProduct(ID);
  }
  public List<Object> getAllProducts(){
    return this.productsAccess.getAllProducts();
  }

  public void saveOrder(Object order){
    this.ordersAccess.saveOrder(order);
  }

  public void deleteOrder(Object order){
    this.ordersAccess.deleteOrder(order);
  }

  public Object getOrder(long ID){
    return this.ordersAccess.getOrder(ID);
  }
  public List<Object> getAllOrders(){
    return this.ordersAccess.getAllOrders();
  }

  public void saveInvoice(Object invoice){
    this.invoiceAccess.saveInvoice(invoice);
  }

  public void deleteInvoice(Object invoice){
    this.invoiceAccess.deleteInvoice(invoice);

  }

  public Object getInvoice(long ID){
    return this.invoiceAccess.getInvoice(ID);
  }
  public List<Object> getAllInvoices(){
    return this.invoiceAccess.getAllInvoices();
  }
}
