package com.backward.sres.config;

import com.backward.common.config.GlobalExceptionConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {GlobalExceptionConfig.class})
public class ExceptionConfig {
}
