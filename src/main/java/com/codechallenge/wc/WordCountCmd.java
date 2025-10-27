package com.codechallenge.wc;

import com.codechallenge.wc.service.FileHandler;
import com.codechallenge.wc.service.FileValidator;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.standard.ShellCommandGroup;

import java.io.IOException;
import java.nio.file.Path;

@Command(command = "ccwc", description = "CLI tool to get the word cound of a text file")
public class WordCountCmd {

    private final FileHandler fileHandler;
    private final FileValidator fileValidator;

    public WordCountCmd(FileHandler fileHandler, FileValidator fileValidator) {
        this.fileHandler = fileHandler;
        this.fileValidator = fileValidator;
    }

    @Command
    public String ccwc(
            @Option(longNames = "c", shortNames = 'c', description = "outputs the number of bytes in a file") boolean c,
            @Option(longNames = "l", shortNames = 'l', description = "outputs the number of lines in a file") boolean l,
            @Option(longNames = "w", shortNames = 'w', description = "outputs the number of words in a file") boolean w,
            @Option(longNames = "m", shortNames = 'm', description = "outputs the number of characters in a file") boolean m,
            @Option(description = "File path") String filePath
    ) throws IOException {

        StringBuilder sb = new StringBuilder();
        Path path = fileValidator.validateFilePath(filePath);

        if(c){
            sb.append("Byte count: ").append(fileHandler.getByteCount(path)).append("\n");
        }

        if(l){
            sb.append("Line count: ").append(fileHandler.getLineCount(path)).append("\n");
        }

        if(w){
            sb.append("Word count: ").append(fileHandler.getWordCount(path)).append("\n");
        }

        if(m){
            sb.append("Char count: ").append(fileHandler.getCharCount(path)).append("\n");
        }

        return sb.toString();
    }

}
