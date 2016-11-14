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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * AOP mit @AspectJ-Annotationen.
 *
 * Achtung, enötigte Abhängikeiten:
 *
 * aopalliance-1.0.jar
 * (http://mvnrepository.com/artifact/aopalliance/aopalliance/1.0)
 *
 * aspectjweaver.jar
 * (s. AspectJ-Installation)
 *
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@Configuration
@EnableAspectJAutoProxy
public class SpringAOP_01 {

  private static String CONFIG_PATH = "classpath*:ae/java/spring/myapp-config.xml";

  @Autowired
  private Hello hello;

  private void start(){
    System.out.println("SpringAOP_01 example starts ...");

    hello.sayHelloWorld();
    hello.sayHello("AOP");

    System.out.println("SpringAOP_01 example done.");
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
    SpringAOP_01 app = context.getBean(SpringAOP_01.class);
    app.start();
  }

}
