package us.mcapi;

import com.fasterxml.jackson.annotation.*;

public class Server {
    private String name;
    private long protocol;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("protocol")
    public long getProtocol() { return protocol; }
    @JsonProperty("protocol")
    public void setProtocol(long value) { this.protocol = value; }
}
