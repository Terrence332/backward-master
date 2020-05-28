package com.backward.sres.config;

import com.backward.common.config.FeignHeaderConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {FeignHeaderConfig.class})
public class FeignConfig {
}
