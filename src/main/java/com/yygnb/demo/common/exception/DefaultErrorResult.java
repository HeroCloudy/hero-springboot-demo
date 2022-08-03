package com.yygnb.demo.common.exception;

import com.yygnb.demo.common.domain.ErrorResult;

/**
 * @Title: com.yygnb.demo.common.exception.DefaultErrorResult
 * @Description: <h1></h1>
 * @Date: 2022/8/3 16:02
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/3 16:02   dscloudy    Create File.
 */
public interface DefaultErrorResult {

    ErrorResult SYSTEM_ERROR = new ErrorResult("C00001", "系统异常");
    ErrorResult CUSTOM_ERROR = new ErrorResult("C99999", "自定义异常");
    ErrorResult PARAM_BIND_ERROR = new ErrorResult("C00003", "参数绑定错误：");
    ErrorResult PARAM_VALID_ERROR = new ErrorResult("S00004", "参数校验错误：");
    ErrorResult JSON_PARSE_ERROR = new ErrorResult("S00005", "JSON转换异常");
    ErrorResult CODE_NOT_FOUND = new ErrorResult("S00006", "根据编码没有查询到对象");
    ErrorResult ID_NOT_FOUND = new ErrorResult("S00007", "根据ID没有查询到对象");

    ErrorResult GATEWAY_INTERNAL_ERROR = new ErrorResult("G00001", "网关发生异常");
    ErrorResult GATEWAY_SERVICE_ERROR = new ErrorResult("G00002", "网关请求的服务不存在");
    ErrorResult PERMISSION_ERROR = new ErrorResult("P00001", "没有权限访问");
}
