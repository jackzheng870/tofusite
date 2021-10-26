package us.mcsrvstat.api;

import com.fasterxml.jackson.annotation.*;

public class Info {
    private String[] raw;
    private String[] clean;
    private String[] html;

    @JsonProperty("raw")
    public String[] getRaw() { return raw; }
    @JsonProperty("raw")
    public void setRaw(String[] value) { this.raw = value; }

    @JsonProperty("clean")
    public String[] getClean() { return clean; }
    @JsonProperty("clean")
    public void setClean(String[] value) { this.clean = value; }

    @JsonProperty("html")
    public String[] getHTML() { return html; }
    @JsonProperty("html")
    public void setHTML(String[] value) { this.html = value; }
}
