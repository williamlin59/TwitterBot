package com.bot.service.impl;


import com.bot.service.WordnikService;
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

@Service
public class WordnikServiceImpl implements WordnikService {
    private Logger log = LoggerFactory.getLogger(WordnikServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${wordnik.url}")
    private String url;

    @Value("${wordnik.apiKey}")
    private String apiKey;

    @Override
    public String getThreeWords() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> response = restTemplate.exchange
                (getBuilder().build().encode().toUri(), HttpMethod.GET, new HttpEntity(headers), String.class);
        log.info("Location is {}", response.getBody());
        return response.getBody();
    }

    private UriComponentsBuilder getBuilder() {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("minDictionaryCount", -1000)
                .queryParam("maxDictionaryCount", 1000)
                .queryParam("limit", 3)
                .queryParam("api_key", apiKey);
    }
}
