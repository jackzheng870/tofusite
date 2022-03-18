package io.github.jackzheng870.tofusite;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import lombok.Data;

@Data
public class MinecraftServerStatus {
    private boolean online;
    private Version version;
    private Player player;
    private List<Profile> sample;
    private List<Text> motd;

    public MinecraftServerStatus(Consumer<MinecraftServerStatus> consumer) {
        consumer.accept(this);
    }

    @Data
    public class Version {
        private String name;
        private int protocol;

        public Version(Consumer<Version> consumer) {
            consumer.accept(this);
        }
    }

    @Data
    public class Player {
        private int max;
        private int online;

        public Player(Consumer<Player> consumer) {
            consumer.accept(this);
        }
    }

    @Data
    public class Profile {
        private UUID id;
        private String name;

        public Profile(Consumer<Profile> consumer) {
            consumer.accept(this);
        }
    }

    @Data
    public class Text {
        private String content;
        private String color;
        private Map<String, String> decorations;

        public Text(Consumer<Text> consumer) {
            consumer.accept(this);
        }
    }
}
