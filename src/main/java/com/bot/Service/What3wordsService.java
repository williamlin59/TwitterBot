package com.bot.service;

import com.bot.domain.WordnikWord;

import java.util.List;


public interface What3wordsService {

    List<String> getLocation(List<WordnikWord> words);

}
