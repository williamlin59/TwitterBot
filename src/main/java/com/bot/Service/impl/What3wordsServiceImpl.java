package com.bot.service.impl;

import com.bot.service.What3wordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class What3wordsServiceImpl implements What3wordsService {
    private Logger log = LoggerFactory.getLogger(What3wordsServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${what3words.url}")
    private String url;

    @Value("${what3words.apiKey}")
    private String apiKey;

    @Override
    public List<String> getLocation(String keyWords) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> response =restTemplate.exchange
                (getBuilder(keyWords).build().encode().toUri(),HttpMethod.GET, new HttpEntity(headers), String.class);
        log.info("Location is {}",response.getBody());
        return null;
    }

    private UriComponentsBuilder getBuilder(String keyWords){
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("addr",keyWords)
                .queryParam("lang","en")
                .queryParam("count", 1)
                .queryParam("key",apiKey);
    }
}
