package com.backward.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
@AllArgsConstructor
public enum HttpCode {
    SUCCESS(HttpServletResponse.SC_OK, "Operation is Successful"),

    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "Request Unauthorized"),

    SC_FORBIDDEN(HttpServletResponse.SC_FORBIDDEN, "Method Need Full Authority"),

    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error"),

    BAD_REQUEST(HttpServletResponse.SC_BAD_REQUEST, "Wrong Username or Password");

    final int code;

    final String msg;
}
