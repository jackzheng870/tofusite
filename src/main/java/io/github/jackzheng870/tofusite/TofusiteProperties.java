package io.github.jackzheng870.tofusite;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties("tofusite")
@Component
@Data
public class TofusiteProperties {
    private String name = "豆服";
    private String host = "server.tofuhero.me";
    private int port = 25565;
    private int timeout = 10;
}
