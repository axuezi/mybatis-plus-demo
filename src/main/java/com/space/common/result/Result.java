package com.space.common.result;

import com.space.common.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果封装类
 *
 * @author axue
 */
@Data
public class Result implements Serializable {

    /**
     * 状态
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    public Result() {

    }

    /**
     * 返回成功，无数据
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    /**
     * 返回成功，有数据
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 返回失败，无数据
     */
    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }

    /**
     * 返回失败，有数据
     *
     * @param resultCode 返回状态
     * @param data       数据
     * @return 返回失败，有数据
     */
    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setData(data);
        return result;
    }

}
