package com.bot.repository.impl;


import com.bot.domain.WordnikWord;
import com.bot.repository.What3wordsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class What3wordsRepositoryImpl implements What3wordsRepository {
    @Override
    public String mapWordnikWordsToWhat3words(List<WordnikWord> wordnikWordList) {
        return wordnikWordList.stream().map(WordnikWord::getWord).collect(Collectors.joining("."));
    }
}
