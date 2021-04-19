package com.space.common.enums;

import lombok.Getter;

/**
 * 返回状态枚举
 *
 * @author axue
 */
@Getter
public enum ResultCode {

    /**
     * 返回状态枚举值
     */
    SUCCESS(200, "成功"),
    PARAM_IS_INVALID(1001,"参数无效"),
    ;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
