package com.bot.service;


import com.bot.domain.WordnikWord;

import java.util.List;

public interface WordnikService {
    List<WordnikWord> getThreeWords();
}
