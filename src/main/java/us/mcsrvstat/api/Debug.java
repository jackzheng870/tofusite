package us.mcsrvstat.api;

import com.fasterxml.jackson.annotation.*;

public class Debug {
    private boolean ping;
    private boolean query;
    private boolean srv;
    private boolean querymismatch;
    private boolean ipinsrv;
    private boolean cnameinsrv;
    private boolean animatedmotd;
    private long cachetime;
    private long apiversion;

    @JsonProperty("ping")
    public boolean getPing() { return ping; }
    @JsonProperty("ping")
    public void setPing(boolean value) { this.ping = value; }

    @JsonProperty("query")
    public boolean getQuery() { return query; }
    @JsonProperty("query")
    public void setQuery(boolean value) { this.query = value; }

    @JsonProperty("srv")
    public boolean getSrv() { return srv; }
    @JsonProperty("srv")
    public void setSrv(boolean value) { this.srv = value; }

    @JsonProperty("querymismatch")
    public boolean getQuerymismatch() { return querymismatch; }
    @JsonProperty("querymismatch")
    public void setQuerymismatch(boolean value) { this.querymismatch = value; }

    @JsonProperty("ipinsrv")
    public boolean getIpinsrv() { return ipinsrv; }
    @JsonProperty("ipinsrv")
    public void setIpinsrv(boolean value) { this.ipinsrv = value; }

    @JsonProperty("cnameinsrv")
    public boolean getCnameinsrv() { return cnameinsrv; }
    @JsonProperty("cnameinsrv")
    public void setCnameinsrv(boolean value) { this.cnameinsrv = value; }

    @JsonProperty("animatedmotd")
    public boolean getAnimatedmotd() { return animatedmotd; }
    @JsonProperty("animatedmotd")
    public void setAnimatedmotd(boolean value) { this.animatedmotd = value; }

    @JsonProperty("cachetime")
    public long getCachetime() { return cachetime; }
    @JsonProperty("cachetime")
    public void setCachetime(long value) { this.cachetime = value; }

    @JsonProperty("apiversion")
    public long getApiversion() { return apiversion; }
    @JsonProperty("apiversion")
    public void setApiversion(long value) { this.apiversion = value; }
}
