package com.bot.service.impl;


import com.bot.domain.WordnikWord;
import com.bot.repository.WordnikRepository;
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

import java.net.URI;
import java.util.List;

@Service
public class WordnikServiceImpl implements WordnikService {
    private Logger log = LoggerFactory.getLogger(WordnikServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WordnikRepository wordnikRepository;

    @Value("${wordnik.url}")
    private String url;

    @Value("${wordnik.apiKey}")
    private String apiKey;


    @Override
    public List<WordnikWord> getThreeWords() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> response = restTemplate.exchange
                (getBuilder(), HttpMethod.GET, new HttpEntity(headers), String.class);
        log.info("Retrived three words are {}", response.getBody());
        return wordnikRepository.mapRandomWordsToWordList(response.getBody());
    }

    private URI getBuilder() {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("minDictionaryCount", -1)
                .queryParam("maxDictionaryCount", 1)
                .queryParam("limit", 3)
                .queryParam("hasDictionaryDef", false)
                .queryParam("api_key", apiKey).build().encode().toUri();
    }
}
