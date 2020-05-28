package com.backward.common.config;

import com.backward.common.filter.ResourceTokenFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ResourceTokenFilter.class})
public class TokenResolveConfig {
}
