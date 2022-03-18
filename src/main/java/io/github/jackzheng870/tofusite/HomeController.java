package io.github.jackzheng870.tofusite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private TofusiteProperties properties;

    public HomeController(TofusiteProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", properties.getName());
        model.addAttribute("host", properties.getHost());
        model.addAttribute("port", properties.getPort());
        return "home";
    }
}
