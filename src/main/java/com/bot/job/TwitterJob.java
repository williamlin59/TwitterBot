package com.bot.job;


import com.bot.domain.WordnikWord;
import com.bot.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ValidationService validationService;

    @Scheduled(cron = "${job.publishCron}")
    public void reportCurrentTime() throws IOException {

        List<WordnikWord> wordnikWords;
        while (validationService.validThreeWords(wordnikWords = wordnikService.getThreeWords())) {
        }
        String json = what3wordsService.getLocation(wordnikWords);
        googleMapService.getMapImage(json);
        String words = wordnikWords.stream().map(WordnikWord::getWord).collect(Collectors.joining(","));
        twitterService.tweet(words, "image.jpg");
        log.info("The time is now {}", wordnikWords);
    }
}
