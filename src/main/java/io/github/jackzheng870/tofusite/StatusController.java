package io.github.jackzheng870.tofusite;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.steveice10.mc.protocol.MinecraftConstants;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.mc.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.protocol.data.status.handler.ServerInfoHandler;
import com.github.steveice10.packetlib.tcp.TcpClientSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

@RestController
public class StatusController {
    private TofusiteProperties properties;

    public StatusController(TofusiteProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/status")
    public MinecraftServerStatus status() {
        return new MinecraftServerStatus(status -> {
            getServerStatusInfo().ifPresentOrElse(info -> {
                status.setOnline(true);
                status.setVersion(status.new Version(version -> {
                    version.setName(info.getVersionInfo().getVersionName());
                    version.setProtocol(info.getVersionInfo().getProtocolVersion());
                }));
                status.setPlayer(status.new Player(player -> {
                    player.setMax(info.getPlayerInfo().getMaxPlayers());
                    player.setOnline(info.getPlayerInfo().getOnlinePlayers());
                }));
                status.setSample(Arrays.stream(info.getPlayerInfo().getPlayers()).map(gameProfile -> {
                    return status.new Profile(profile -> {
                        profile.setId(gameProfile.getId());
                        profile.setName(gameProfile.getName());
                    });
                }).toList());
                status.setMotd(Stream.of(info.getDescription()).mapMulti(this::expandComponent)
                        .filter(TextComponent.class::isInstance).map(TextComponent.class::cast)
                        .filter(textComponent -> !textComponent.content().isEmpty()).map(textComponent -> {
                            return status.new Text(text -> {
                                text.setContent(textComponent.content());
                                TextColor color = textComponent.color();
                                if (color != null) {
                                    text.setColor(color.toString());
                                }
                                text.setDecorations(textComponent.decorations().entrySet().stream()
                                        .collect(Collectors.toMap(entry -> entry.getKey().toString(),
                                                entry -> entry.getValue().toString())));
                            });
                        }).toList());
            }, () -> status.setOnline(false));
        });
    }

    private Optional<ServerStatusInfo> getServerStatusInfo() {
        CompletableFuture<ServerStatusInfo> future = new CompletableFuture<>();
        TcpClientSession client = new TcpClientSession(properties.getHost(), properties.getPort(),
                new MinecraftProtocol());
        client.setFlag(MinecraftConstants.SERVER_INFO_HANDLER_KEY,
                (ServerInfoHandler) (session, info) -> future.complete(info));
        client.connect();
        try {
            return Optional.of(future.get(properties.getTimeout(), TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private void expandComponent(Component component, Consumer<Component> consumer) {
        consumer.accept(component);
        if (!component.children().isEmpty()) {
            component.children().forEach(child -> expandComponent(child, consumer));
        }
    }
}
