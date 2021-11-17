package us.mcapi;

import com.fasterxml.jackson.annotation.*;
import java.util.UUID;

public class Sample {
    private String name;
    private UUID id;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("id")
    public UUID getID() { return id; }
    @JsonProperty("id")
    public void setID(UUID value) { this.id = value; }
}
