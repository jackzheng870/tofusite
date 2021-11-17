package us.mcapi;

import com.fasterxml.jackson.annotation.*;

public class Players {
    private long max;
    private long now;
    private Sample[] sample;

    @JsonProperty("max")
    public long getMax() { return max; }
    @JsonProperty("max")
    public void setMax(long value) { this.max = value; }

    @JsonProperty("now")
    public long getNow() { return now; }
    @JsonProperty("now")
    public void setNow(long value) { this.now = value; }

    @JsonProperty("sample")
    public Sample[] getSample() { return sample; }
    @JsonProperty("sample")
    public void setSample(Sample[] value) { this.sample = value; }
}
