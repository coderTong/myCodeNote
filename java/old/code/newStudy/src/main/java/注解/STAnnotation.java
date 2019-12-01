package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by codew on 2018/4/18.
 */

@Retention(RetentionPolicy.RUNTIME) // 表示在JVM中存在
@Target({ElementType.TYPE, ElementType.METHOD}) // 该注解
public @interface STAnnotation {

    int level() default 1;
    String value();

}
