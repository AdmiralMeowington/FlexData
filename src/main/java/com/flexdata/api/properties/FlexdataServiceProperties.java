package com.flexdata.api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class FlexdataServiceProperties {
    private String host = "http://flexdata";
    private int publicListSize = 10;
}
