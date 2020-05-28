package com.backward.common.config;

import com.backward.common.error.GlobalExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {GlobalExceptionTranslator.class})
public class GlobalExceptionConfig {
}
