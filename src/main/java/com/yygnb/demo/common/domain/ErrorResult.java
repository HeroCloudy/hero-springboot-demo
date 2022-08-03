package com.yygnb.demo.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Title: com.yygnb.demo.common.domain.ErrorResult
 * @Description: <h1></h1>
 * @Date: 2022/8/3 16:00
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/3 16:00   dscloudy    Create File.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult implements Serializable {

    private static final long serialVersionUID = -8738363760223125457L;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String msg;

    public static ErrorResult build(ErrorResult commonErrorResult, String msg) {
        return new ErrorResult(commonErrorResult.getCode(), commonErrorResult.getMsg() + " " + msg);
    }
}
