package com.bot.service;


import java.io.IOException;

public interface GoogleMapService {
    void getMapImage(String json) throws IOException;
}
