package com.github.bbodnar.signature.starter.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Duration;

@Getter
@Setter
@Validated
@ConfigurationProperties("demo.signature")
public class SignatureProperties {

    /**
     * Username for username signature
     */
    @NotBlank
    @Size(min = 4, max = 10)
    private String username = "NONAME";

    @Valid
    @NestedConfigurationProperty
    private Extra extra = new Extra();

    @Getter
    @Setter
    public static class Extra {

        /**
         * Retention period for email.
         */
        @DurationMin(minutes = 5)
        @DurationMax(hours = 1)
        private Duration retentionPeriod = Duration.ofMinutes(5);
    }
}
