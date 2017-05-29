package com.bot.service.impl;

import com.bot.domain.WordnikWord;
import com.bot.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validThreeWords(List<WordnikWord> threeWords) {
        return threeWords.stream().
                filter(threeWord -> !threeWord.getWord().chars().allMatch(Character::isLetter)).
                findAny().isPresent();
    }
}
