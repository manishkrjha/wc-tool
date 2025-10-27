package com.codechallenge.wc.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileValidator {

    public Path validateFilePath(String filePath){
        if(filePath.isBlank()){
            throw new IllegalArgumentException("No file is provided");
        }

        Path path = Path.of(filePath);

        if(!Files.exists(path)){
            throw new IllegalArgumentException("No such file exists at the location");
        }

        if(Files.isDirectory(path)){
            throw new IllegalArgumentException("Invalid file name provided");
        }

        if(!Files.isReadable(path)){
            throw new IllegalArgumentException("The file you've added is not readable");
        }

        return path;
    }


}
