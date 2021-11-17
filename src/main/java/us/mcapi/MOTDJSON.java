package us.mcapi;

import com.fasterxml.jackson.annotation.*;

public class MOTDJSON {
    private Extra[] extra;
    private String text;

    @JsonProperty("extra")
    public Extra[] getExtra() { return extra; }
    @JsonProperty("extra")
    public void setExtra(Extra[] value) { this.extra = value; }

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }
}
