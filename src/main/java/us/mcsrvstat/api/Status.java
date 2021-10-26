package us.mcsrvstat.api;

import com.fasterxml.jackson.annotation.*;

public class Status {
    private String ip;
    private long port;
    private Debug debug;
    private Info motd;
    private Players players;
    private String version;
    private boolean online;
    private long protocol;
    private String hostname;
    private String software;
    private Info info;

    @JsonProperty("ip")
    public String getIP() { return ip; }
    @JsonProperty("ip")
    public void setIP(String value) { this.ip = value; }

    @JsonProperty("port")
    public long getPort() { return port; }
    @JsonProperty("port")
    public void setPort(long value) { this.port = value; }

    @JsonProperty("debug")
    public Debug getDebug() { return debug; }
    @JsonProperty("debug")
    public void setDebug(Debug value) { this.debug = value; }

    @JsonProperty("motd")
    public Info getMOTD() { return motd; }
    @JsonProperty("motd")
    public void setMOTD(Info value) { this.motd = value; }

    @JsonProperty("players")
    public Players getPlayers() { return players; }
    @JsonProperty("players")
    public void setPlayers(Players value) { this.players = value; }

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }

    @JsonProperty("online")
    public boolean getOnline() { return online; }
    @JsonProperty("online")
    public void setOnline(boolean value) { this.online = value; }

    @JsonProperty("protocol")
    public long getProtocol() { return protocol; }
    @JsonProperty("protocol")
    public void setProtocol(long value) { this.protocol = value; }

    @JsonProperty("hostname")
    public String getHostname() { return hostname; }
    @JsonProperty("hostname")
    public void setHostname(String value) { this.hostname = value; }

    @JsonProperty("software")
    public String getSoftware() { return software; }
    @JsonProperty("software")
    public void setSoftware(String value) { this.software = value; }

    @JsonProperty("info")
    public Info getInfo() { return info; }
    @JsonProperty("info")
    public void setInfo(Info value) { this.info = value; }
}
