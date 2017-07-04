package com.shmily.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shmily on 2017/6/8.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {
    /**
     * 权限的名称
     * @return
     */
    String value() default "";

    /**
     * 权限描述
     * @return
     */
    String name() default "";

    /**
     * 该权限是否启用
     * @return
     */
    boolean enable() default true;
}
