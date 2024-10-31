package net.kamal.customerservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;
}
