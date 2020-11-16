package com.mingyuan.bangbang.advice;

import com.mingyuan.bangbang.exceptions.TokenExceptions;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.util.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = { "com.mingyuan" })
public class ControllerExceptionAdvice {
    @ExceptionHandler(TokenExceptions.class)
    private ResultVo handleServiceException(TokenExceptions exception) {
        String message = exception.getLocalizedMessage();
        return ResultUtil.errorWithMsg(message);
    }
}
