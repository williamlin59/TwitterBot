package com.bot.repository;

import com.bot.domain.WordnikWord;

import java.util.List;


public interface WordnikRepository {
    List<WordnikWord> mapRandomWordsToWordList(String randomWords);

}
