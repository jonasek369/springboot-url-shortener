package me.jonas.urlshortener.shorten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class ShortenService {

    private final ShortenRepository shortenRepository;

    @Autowired
    public ShortenService(ShortenRepository shortenRepository) {
        this.shortenRepository = shortenRepository;
    }

    public String createShorten(String points){
        Shorten saved = shortenRepository.save(new Shorten(points));
        return saved.getShorten();
    }

    public String getShorten(String shorten){
        Optional<Shorten> fetch = shortenRepository.findById(shorten);
        if(fetch.isEmpty()){
            return "/error";
        }else{
            return fetch.get().getPoints();
        }
    }
}
