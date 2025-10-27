package com.codechallenge.wc.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileHandler {

    private final String ERROR_MESSAGE = "Exception occurred while reading file: {}";

    public String getWordCount(Path filePath){
        try{
            Stream<String> lines = Files.lines(filePath);

            List<String> wordList = lines
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .toList();

            return Integer.toString(wordList.size());
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE, e);
        }
    }

    public String getLineCount(Path filePath){
        try{
            Stream<String> lines = Files.lines(filePath);
            return Long.toString(lines.count());
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE, e);
        }
    }

    public String getCharCount(Path filePath){

        try {
            Stream<String> lines = Files.lines(filePath);
            int charCount = lines.mapToInt(String::length).sum();
            return Integer.toString(charCount);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE, e);
        }
    }

    public String getByteCount(Path filePath) throws IOException {
        return Long.toString(Files.size(filePath));
    }

}
