package com.space.common.annotation;

import java.lang.annotation.*;

/**
 * 1、定义一个注解@ResponseResult，表示这个接口返回的值需要包装一下
 * 2、拦截请求，判断此请求是否需要被@ResponseResult注解
 * 3、核心步骤就是实现接口ResponseBodyAdvice和@ControllerAdvice，判断是否需要包装返回值，如果需要，就把Controller接口的返回值进行重写。
 *
 * @author axue
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {

}
