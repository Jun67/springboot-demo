package com.bailiban.springboot.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private static String MSG = "World";

    private String msg = MSG;
}
