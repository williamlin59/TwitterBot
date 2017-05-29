package com.bot.service;

import com.bot.domain.WordnikWord;

import java.util.List;

/**
 * Created by William on 29/05/2017.
 */
public interface ValidationService {
    boolean validThreeWords(List<WordnikWord> threeWords);
}
