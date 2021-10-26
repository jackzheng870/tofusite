package io.github.jackzheng870.tofusite;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import us.mcsrvstat.api.Converter;

@Controller
public class HomeController {
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.mcsrvstat.us/2/server.tofuhero.me")).build();

    @GetMapping("/")
    public String home(Model model) {
        try {
            model.addAttribute("online",
                    Converter.fromJsonString(client.send(request, BodyHandlers.ofString()).body()).getOnline());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "home";
    }
}
