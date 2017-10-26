package com.secondhandcar.platform.service;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
@Inherited
public @interface Component {
    String identifier () default "";
}