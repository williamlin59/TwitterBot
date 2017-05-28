package com.bot.Service.impl;


import com.bot.Service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterServiceImpl implements TwitterService {
    private Logger log = LoggerFactory.getLogger(TwitterServiceImpl.class);

    @Autowired
    private Twitter twitterClient;
    @Override
    public void tweet(String tweet) {
        try {
            twitterClient.updateStatus(tweet);
        } catch (TwitterException e) {
            log.error("Unable post twitter!!!!",e);
        }
    }
}
