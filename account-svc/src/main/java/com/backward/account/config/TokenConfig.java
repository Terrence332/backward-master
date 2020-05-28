package com.backward.account.config;

import com.backward.common.config.TokenResolveConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {TokenResolveConfig.class})
public class TokenConfig {
}
