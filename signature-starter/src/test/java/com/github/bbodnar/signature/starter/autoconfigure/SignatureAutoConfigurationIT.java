package com.github.bbodnar.signature.starter.autoconfigure;

import com.github.bbodnar.signature.starter.controller.SignatureController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;


public class SignatureAutoConfigurationIT {

    @Test
    void shouldAutoConfigurationBeAppliedToWebApplication() {
        new WebApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(SignatureAutoConfiguration.class))
                .run(context -> assertThat(context).hasNotFailed()
                        .hasSingleBean(SignatureController.class)
                        .hasSingleBean(SignatureProperties.class)
                        .getBean(SignatureProperties.class).hasAllNullFieldsOrProperties());
    }
}
