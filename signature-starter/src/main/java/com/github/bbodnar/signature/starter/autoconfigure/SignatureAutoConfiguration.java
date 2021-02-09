package com.github.bbodnar.signature.starter.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.github.bbodnar.signature.starter")
@ConditionalOnProperty(value = "demo.signature.enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(SignatureProperties.class)
public class SignatureAutoConfiguration {
}
