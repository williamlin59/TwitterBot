package com.bot.service.impl;


import com.bot.service.GoogleMapService;
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class GoogleMapServiceImpl implements GoogleMapService {
    private Logger log = LoggerFactory.getLogger(GoogleMapServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${googleMap.url}")
    private String url;

    @Value("${googleMap.apiKey}")
    private String apiKey;

    @Value("${googleMap.size}")
    private String size;

    @Value("${googleMap.zoom}")
    private int zoom;


    @Override
    public void getMapImage(String location, String center) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<byte[]> response = restTemplate.exchange
                (getBuilder(location, center).build().encode().toUri(), HttpMethod.GET, new HttpEntity(headers), byte[].class);
        log.info("Response content {}", response.getBody());
        Files.write(Paths.get("image.jpg"), response.getBody());
    }

    private UriComponentsBuilder getBuilder(String location, String center) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("center", center)
                .queryParam("zoom", zoom)
                .queryParam("size", size)
                .queryParam("markers", "color:red|label:S| " + location)
                .queryParam("key", apiKey);
    }
}
