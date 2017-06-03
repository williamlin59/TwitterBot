package com.bot.service;

import java.io.File;

/**
 * Created by William on 03/06/2017.
 */
public interface FileService {
    void saveImage(String fileName, byte[] image);

    File getImage(String fileName);
}
