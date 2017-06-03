package com.bot.service.impl;

import com.bot.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void saveImage(String fileName, byte[] image) {
        try {
            Files.write(Paths.get("image.jpg"), image);
        } catch (IOException e) {
            //log
        }
    }

    @Override
    public File getImage(String fileName) {
        return new File(fileName);
    }
}
