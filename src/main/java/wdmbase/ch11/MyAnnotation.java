package wdmbase.ch11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//指定接口可以放在什么上面，ElementType.Type是类上面，ElementType.method是方法上面，ElementType.FIELD是属性上面......
@Target({ElementType.FIELD})
//指定保存方式，RetentionPolicy.Source是只保存在源文件中，
// RetentionPolicy.Class表明保存在class文件中，
// RetentionPolicy.Runtime表明保存在class中，并且可以通过反射机制拿到
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "";
}
