package com.backward.common.config;

import com.backward.common.interceptor.FeignHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {FeignHeaderInterceptor.class})
public class FeignHeaderConfig {
}
