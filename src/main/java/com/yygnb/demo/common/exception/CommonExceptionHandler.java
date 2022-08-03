package com.yygnb.demo.common.exception;

import com.yygnb.demo.common.domain.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: com.yygnb.demo.common.exception.CommonExceptionHandler
 * @Description: <h1></h1>
 * @Date: 2022/8/3 16:06
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/3 16:06   dscloudy    Create File.
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBindException(BindException e) {
        log.error("{}", e.getMessage(), e);
        List<String> defaultMsg = e.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return ErrorResult.build(DefaultErrorResult.PARAM_BIND_ERROR, defaultMsg.get(0));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("{}", e.getMessage(), e);
        List<String> defaultMsg = e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> "【" + fieldError.getField() + "】" + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        return ErrorResult.build(DefaultErrorResult.PARAM_VALID_ERROR, defaultMsg.get(0));
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("{}", e.getMessage(), e);
        log.error("ParameterName: {}", e.getParameterName());
        log.error("ParameterType: {}", e.getParameterType());
        return ErrorResult.build(DefaultErrorResult.PARAM_VALID_ERROR, e.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBindGetException(ConstraintViolationException e) {
        log.error("{}", e.getMessage(), e);
        List<String> defaultMsg = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return ErrorResult.build(DefaultErrorResult.PARAM_VALID_ERROR, defaultMsg.get(0));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult error(HttpMessageNotReadableException e){
        log.error("{}", e.getMessage(), e);
        return DefaultErrorResult.JSON_PARSE_ERROR;
    }

    /**
     * 通用业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = CommonException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResult handleCommonException(CommonException e) {
        log.error("{}, {}", e.getMessage(), e);
        if (e.getErrorResult() != null) {
            return e.getErrorResult();
        }
        return new ErrorResult(DefaultErrorResult.CUSTOM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 其他运行时异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResult handleDefaultException(Exception e) {
        log.error("{}, {}", e.getMessage(), e);
        return DefaultErrorResult.SYSTEM_ERROR;
    }
}
