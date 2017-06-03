package com.bot.repository.impl;

import com.bot.repository.GoogleMapRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GoogleMapRepositoryImpl implements GoogleMapRepository {
    @Override
    public String getLocation(String json) {
        JSONObject geometry = (JSONObject) getSuggestion(json).get().get("geometry");
        String lat = geometry.get("lat").toString();
        String lng = geometry.get("lng").toString();
        return lng + "," + lat;

    }

    @Override
    public String getCenter(String json) {
        return getSuggestion(json).get().get("place").toString();
    }

    private Optional<JSONObject> getSuggestion(String json) {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObj = (JSONObject) jsonParser.parse(json);
            JSONArray array = (JSONArray) jsonObj.get("suggestions");
            return Optional.of((JSONObject) array.iterator().next());
        } catch (ParseException e) {
            //Log
        }
        return Optional.empty();
    }
}
