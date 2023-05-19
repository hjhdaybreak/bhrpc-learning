package io.binghe.rpc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RpcServer {

    Class<?> interfaceClass() default void.class;

    String interfaceName() default "";

    String version() default "1.0.0";

    String group() default "";

}
