package me.jonas.urlshortener.shorten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class ShortenController {
    private final ShortenService shortenService;

    @Autowired
    public ShortenController(ShortenService shortenService){
        this.shortenService = shortenService;
    }

    @PostMapping("/create")
    public String createShorten(@RequestBody Map<String, String> payload){
        if(!payload.containsKey("points")){
            return "error";
        }
        return shortenService.createShorten(payload.get("points"));
    }

    @GetMapping("/{shorten}")
    public RedirectView redirectShorten(@PathVariable String shorten){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(shortenService.getShorten(shorten));
        return redirectView;
    }
}
