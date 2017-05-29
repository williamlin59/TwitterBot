package com.bot.job;


import com.bot.service.GoogleMapService;
import com.bot.service.TwitterService;
import com.bot.service.What3wordsService;
import com.bot.service.WordnikService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@EnableScheduling
public class TwitterJob {
    private Logger log = LoggerFactory.getLogger(TwitterJob.class);
    @Autowired
    private TwitterService twitterService;

    @Autowired
    private What3wordsService what3wordsService;

    @Autowired
    private GoogleMapService googleMapService;

    @Autowired
    private WordnikService wordnikService;
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws IOException {
//        twitterService.tweet(LocalDateTime.now()+"");
//        what3wordsService.getLocation("plan.clips.a");
//        googleMapService.getMapImage("39.415413,-74.507625", "Absecon, New Jersey");
        wordnikService.getThreeWords();
        log.info("The time is now {}", LocalDateTime.now());
    }
}
