package com.backward.common.error;

import com.backward.common.api.BaseResponse;
import com.backward.common.api.HttpCode;
import com.backward.common.exception.WrongPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionTranslator {

    // 用户名或密码错误
    // security.oauth2.common.exceptions.InvalidGrantException
    @ExceptionHandler(InvalidGrantException.class)
    public BaseResponse handleError(InvalidGrantException e){
        log.error("用户名或密码错误", e);
        return BaseResponse.builder()
                .code(HttpCode.BAD_REQUEST)
                .message(e.getMessage())
                .build();
    }

    // 未授权异常
    // security.core.AuthenticationException
    @ExceptionHandler(AuthenticationException.class)
    public BaseResponse handleError(AuthenticationException e){
        log.error("身份认证失败", e);
        return BaseResponse.builder()
                .code(HttpCode.UN_AUTHORIZED)
                .message(e.getMessage())
                .build();
    }

    // 权限不足异常
    // security.access.AccessDeniedException
    @ExceptionHandler(AccessDeniedException.class)
    public BaseResponse handleError(AccessDeniedException e){
        log.error("权限不足", e);
        return BaseResponse.builder()
                .code(HttpCode.SC_FORBIDDEN)
                .message(e.getMessage())
                .build();
    }

    // 用户修改密码时原密码错误
    // com.backward.common.exception.WrongPasswordException
    @ExceptionHandler(WrongPasswordException.class)
    public BaseResponse handleError(WrongPasswordException e){
        log.error("用户密码错误", e);
        return BaseResponse.builder()
                .code(HttpCode.BAD_REQUEST)
                .message(e.getMessage())
                .build();
    }

    // 拦截其他Handler未处理异常
    @ExceptionHandler(Throwable.class)
    public BaseResponse handleError(Throwable e){
        log.error("服务器内部错误", e);
        return BaseResponse.builder()
                .code(HttpCode.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .build();
    }

}
