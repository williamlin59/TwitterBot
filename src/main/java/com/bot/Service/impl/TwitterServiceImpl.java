package com.bot.service.impl;


import com.bot.service.FileService;
import com.bot.service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.io.File;

@Service
public class TwitterServiceImpl implements TwitterService {
    private Logger log = LoggerFactory.getLogger(TwitterServiceImpl.class);

    @Autowired
    private Twitter twitterClient;
    @Autowired
    private FileService fileService;
    @Override
    public void tweet(String tweet, String fileName) {
        File image = fileService.getImage(fileName);
        StatusUpdate status = new StatusUpdate(tweet);
        status.setMedia(image);
        try {
            twitterClient.updateStatus(status);
        } catch (TwitterException e) {
            log.error("Unable post twitter!!!!",e);
        }
    }
}
