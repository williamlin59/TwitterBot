package com.bot.repository;

import com.bot.domain.WordnikWord;

import java.util.List;


public interface What3wordsRepository {
    String mapWordnikWordsToWhat3words(List<WordnikWord> wordnikWordList);

}
