package io.github.jackzheng870.tofusite;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private String name;
    private String server;

    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest mcsrvstatusRequest;
    private HttpRequest mcapiRequest;

    private boolean mcsrvstatusOnline;
    private boolean mcapiOnline;

    public HomeController(TofusiteProperties properties) {
        name = properties.getName();
        server = properties.getServer();

        mcsrvstatusRequest = buildRequest("https://api.mcsrvstat.us/2/" + server);
        mcapiRequest = buildRequest("https://mcapi.us/server/status?ip=" + server);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("server", server);

        CompletableFuture.allOf(sendRequest(mcsrvstatusRequest).thenAccept(json -> {
            try {
                mcsrvstatusOnline = us.mcsrvstat.api.Converter.fromJsonString(json).getOnline();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }), sendRequest(mcapiRequest).thenAccept(json -> {
            try {
                mcapiOnline = us.mcapi.Converter.fromJsonString(json).getOnline();
            } catch (IOException e) {
                e.printStackTrace();
            }
        })).join();

        model.addAttribute("online", mcsrvstatusOnline || mcapiOnline);
        return "home";
    }

    private HttpRequest buildRequest(String uri) {
        return HttpRequest.newBuilder().uri(URI.create(uri)).build();
    }

    private CompletableFuture<String> sendRequest(HttpRequest request) {
        return client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body);
    }
}
