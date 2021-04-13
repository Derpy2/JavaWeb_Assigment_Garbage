package com.javaweb.garbage1.utils;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    //模块名
    String module() default"";

    //方法名
    String methods() default "";

    //描述信息
    String description() default "";
}
