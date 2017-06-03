package com.bot.repository;

public interface GoogleMapRepository {
    String getLocation(String json);

    String getCenter(String json);
}
