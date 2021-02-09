package com.github.bbodnar.signature.starter.controller;

import com.github.bbodnar.signature.starter.autoconfigure.SignatureProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class SignatureController {

    private static final Logger log = LoggerFactory.getLogger(SignatureController.class);

    private final String username;
    private final Duration retentionPeriod;

    public SignatureController(SignatureProperties signatureProperties) {

        this.username = signatureProperties.getUsername();
        this.retentionPeriod = signatureProperties.getExtra().getRetentionPeriod();
        log.info("Using following configuration: 'username' - {}, 'retention period - {}'",
                username, retentionPeriod);
    }


    @GetMapping("/api/v1/signature")
    public String getSignature() {
        return "Best regards,\n" + username + "\n\nEmail will be deleted after: " + retentionPeriod;
    }
}
