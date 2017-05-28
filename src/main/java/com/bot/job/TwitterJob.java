package com.bot.job;

import com.bot.Service.TwitterService;
import com.bot.Service.What3wordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class TwitterJob {
    private Logger log = LoggerFactory.getLogger(TwitterJob.class);
    @Autowired
    private TwitterService twitterService;

    @Autowired
    private What3wordsService what3wordsService;
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
//        twitterService.tweet(LocalDateTime.now()+"");
        what3wordsService.getLocation("plan.clips.a");
        log.info("The time is now {}", LocalDateTime.now());
    }
}
