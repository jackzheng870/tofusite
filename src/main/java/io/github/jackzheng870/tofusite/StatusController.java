package io.github.jackzheng870.tofusite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.github.steveice10.mc.protocol.MinecraftConstants;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.mc.protocol.data.status.handler.ServerPingTimeHandler;
import com.github.steveice10.packetlib.tcp.TcpClientSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    private TofusiteProperties properties;

    public StatusController(TofusiteProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/status")
    public MinecraftServerStatus status() {
        MinecraftServerStatus status = new MinecraftServerStatus();
        status.setOnline(isOnline());
        return status;
    }

    private boolean isOnline() {
        CompletableFuture<Boolean> future = new CompletableFuture<>();
        TcpClientSession client = new TcpClientSession(properties.getHost(), properties.getPort(),
                new MinecraftProtocol());
        client.setFlag(MinecraftConstants.SERVER_PING_TIME_HANDLER_KEY,
                (ServerPingTimeHandler) (session, ping) -> future.complete(true));
        client.connect();
        try {
            return future.get(properties.getTimeout(), TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return false;
    }
}
