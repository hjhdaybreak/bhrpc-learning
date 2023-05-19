package io.binghe.rpc.annotation;


import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Autowired
public @interface RpcReference {

    String version() default "1.0.0";

    String group() default "";

    String registryType() default "zookeeper";

    String registryAddress() default "127.0.0.1";

    String loadBalanceType() default "zkconsistenthash";

    String serializationType() default "protobuf";

    long timeout() default 5000;

    boolean async() default false;

    boolean oneway() default false;

    String proxy() default "jdk";

}
