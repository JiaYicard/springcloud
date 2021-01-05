package com.zzs.springcloud.conmmon;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mountain
 * @since 2020/12/8 22:17
 */
@Data
@NoArgsConstructor
public final class CommonResult<T> implements Serializable {

    /**
     * 成功
     */
    public static final int CODE_SUCCESS=0;

    /**
     * 一般错误
     */
    public static final int CODE_COMMON_ERROR = 1;

    /**
     * 未知错误（服务器内部错误，前端看情况提示）
     */
    public static final int CODE_UNKNOWN_ERROR=4;

    public static final String MESSAGE_UNKNOWN_ERROR="未知错误";

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 错误消息
     */
    private String message;
    /**
     *返回数据
     */
    private T data;

    /**
     * 成功
     * @param data 返回数据
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult(CODE_SUCCESS,null,data);
    }

    /**
     * 失败消息
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> erro(String message){
        return new CommonResult(CODE_COMMON_ERROR,message,null);
    }

    /**
     * 失败
     *
     * @param code   出错码
     * @param message 出错消息
     */
    public static <T> CommonResult<T> error(int code, String message) {
        if (code == 0) {
            return new CommonResult<>(CODE_COMMON_ERROR, message, null);
        }
        return new CommonResult<>(code, message, null);
    }

    /**
     * 未知错误
     */
    public static <T> CommonResult<T> UNKNOWN_ERROR() {
        return error(CODE_UNKNOWN_ERROR, MESSAGE_UNKNOWN_ERROR);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
