package repeatable;

import java.lang.annotation.*;

@Repeatable(People.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Game {
    String value() default "";
}
