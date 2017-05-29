package com.bot.repository.impl;


import com.bot.domain.WordnikWord;
import com.bot.repository.WordnikRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WordnikRepositoryImpl implements WordnikRepository {

    @Autowired
    private Gson gson;

    @Override
    public List<WordnikWord> mapRandomWordsToWordList(String threeWords) {
        Type listType = new TypeToken<ArrayList<WordnikWord>>() {
        }.getType();
        return gson.fromJson(threeWords, listType);
    }
}
