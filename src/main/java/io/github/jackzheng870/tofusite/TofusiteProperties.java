package io.github.jackzheng870.tofusite;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("tofusite")
@Component
public class TofusiteProperties {
    private String name = "豆服";
    private String server = "server.tofuhero.me";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
