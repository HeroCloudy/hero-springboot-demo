package com.yygnb.demo.common.exception;

import com.yygnb.demo.common.domain.ErrorResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: com.yygnb.demo.common.exception.CommonException
 * @Description: <h1></h1>
 * @Date: 2022/8/3 16:05
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/3 16:05   dscloudy    Create File.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {

    protected ErrorResult errorResult;

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    protected CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CommonException(String code, String msg) {
        super(msg + "(" + code + ")");
        this.errorResult = new ErrorResult(code, msg);
    }

    public CommonException(ErrorResult errorResult) {
        super(errorResult.getMsg() + "(" + errorResult.getCode() + ")");
        this.errorResult = errorResult;
    }
}
