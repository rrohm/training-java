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
package ae.java.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * This is an aspect class, i.e.:
 * <ul>
 * <li>It may have fields, methods etc like any other class, but it also may
 * contain ...</li>
 * <li>pointcut definitions,  </li>
 * <li>advice definitions, </li>
 * <li>introduction definitions. </li>
 * </ul>
 *
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@Aspect
//@Component     // Funktioniert, ersetzt Deklaration in Spring-Konfig.
//@Configuration // Funktioniert, ist aber semantisch nicht ganz passend
public class MyAspect {

  @Pointcut("execution(public * Hello.*(..))")
  private void trackAnything() { }

  @Pointcut("@annotation(ae.java.spring.MyAspectAnnotation)")
  private void trackByAnnotation() { }


  @Before("trackAnything()")
  public void processBeforeTracking(JoinPoint joinPoint) throws Throwable {
    System.out.println("... " + joinPoint);
  }
  @After("trackAnything()")
  public void processAfterTracking(JoinPoint joinPoint) throws Throwable {
    System.out.println("--- " + joinPoint);
  }
  @AfterThrowing("trackAnything()")
  public void processAfterThrowing(JoinPoint joinPoint) throws Throwable {
    System.out.println("xxx " + joinPoint);
  }
  @AfterReturning("trackAnything()")
  public void processAfterReturning(JoinPoint joinPoint) throws Throwable {
    System.out.println("=== " + joinPoint);
  }

  @Around("trackAnything()")
  public Object processTracking(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("--> " + joinPoint);
    Object result = joinPoint.proceed();
    System.out.println("<-- " + joinPoint);
    return result;
  }

  @Around("trackByAnnotation()")
  public Object processAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("-----> " + joinPoint);
    Object result = joinPoint.proceed();
    System.out.println("<----- " + joinPoint);
    return result;
  }
}
