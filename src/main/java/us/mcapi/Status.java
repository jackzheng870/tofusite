package us.mcapi;

import com.fasterxml.jackson.annotation.*;

public class Status {
    private String status;
    private boolean online;
    private String motd;
    private MOTDJSON motdJSON;
    private String favicon;
    private String error;
    private Players players;
    private Server server;
    private String lastUpdated;
    private String duration;

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("online")
    public boolean getOnline() { return online; }
    @JsonProperty("online")
    public void setOnline(boolean value) { this.online = value; }

    @JsonProperty("motd")
    public String getMOTD() { return motd; }
    @JsonProperty("motd")
    public void setMOTD(String value) { this.motd = value; }

    @JsonProperty("motd_json")
    public MOTDJSON getMOTDJSON() { return motdJSON; }
    @JsonProperty("motd_json")
    public void setMOTDJSON(MOTDJSON value) { this.motdJSON = value; }

    @JsonProperty("favicon")
    public String getFavicon() { return favicon; }
    @JsonProperty("favicon")
    public void setFavicon(String value) { this.favicon = value; }

    @JsonProperty("error")
    public String getError() { return error; }
    @JsonProperty("error")
    public void setError(String value) { this.error = value; }

    @JsonProperty("players")
    public Players getPlayers() { return players; }
    @JsonProperty("players")
    public void setPlayers(Players value) { this.players = value; }

    @JsonProperty("server")
    public Server getServer() { return server; }
    @JsonProperty("server")
    public void setServer(Server value) { this.server = value; }

    @JsonProperty("last_updated")
    public String getLastUpdated() { return lastUpdated; }
    @JsonProperty("last_updated")
    public void setLastUpdated(String value) { this.lastUpdated = value; }

    @JsonProperty("duration")
    public String getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(String value) { this.duration = value; }
}
