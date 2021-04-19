package com.space.common.handler;

import com.space.common.annotation.ResponseResult;
import com.space.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 重写返回体: 判断是否需要返回值包装，如果需要就直接包装
 *
 * @author axue
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 标记名称
     */
    public final static String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    /**
     * 是否请求了包含注解的接口，没有直接返回，不需要包装
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        // 判断请求是否有标记
        ResponseResult result = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return result != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends
            HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("进入返回体重写格式处理中 -> {}", body);
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }

}
