package com.muyenet.muye.core.annotation;

import com.muyenet.muye.interceptor.MuyeInterceptor;

import java.lang.annotation.*;

/**
 * Created by zchuanzhao on 2016/11/26.
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface After {
    Class<? extends MuyeInterceptor> value();
}
