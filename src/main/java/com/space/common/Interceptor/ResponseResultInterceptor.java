package com.space.common.Interceptor;

import com.space.common.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截请求，是否此请求返回的值需要包装，其实就是运行的时候，解析@ResponseResult注解
 *
 * @author axue
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    /**
     * 标记名称
     */
    public final static String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求的方法
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            // 判断类对象是否添加注解，或者方法上是否添加注解
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT_ANN, clazz.getDeclaredAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT_ANN, method.getDeclaredAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
