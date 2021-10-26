package us.mcsrvstat.api;

import com.fasterxml.jackson.annotation.*;

public class Players {
    private long online;
    private long max;

    @JsonProperty("online")
    public long getOnline() { return online; }
    @JsonProperty("online")
    public void setOnline(long value) { this.online = value; }

    @JsonProperty("max")
    public long getMax() { return max; }
    @JsonProperty("max")
    public void setMax(long value) { this.max = value; }
}
