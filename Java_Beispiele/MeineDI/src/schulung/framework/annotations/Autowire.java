package schulung.framework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation für Felder, in die eine Instanz injiziert werden soll.
 * Die Annotation muss zur Laufzeit ausgewertet werden können,
 * und sie soll nur an Feldern verwendet werden können (s.
 * @Retention und @Target).
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowire {

}
