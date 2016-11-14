/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.ejb.interceptors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author robert rohm
 */
@Interceptor
public class BeanInterceptor {

  @PostConstruct
  public void nachErzeugung(InvocationContext ctx){

  }

  @PreDestroy
  public void vorDestroy(InvocationContext ctx){

  }

}
