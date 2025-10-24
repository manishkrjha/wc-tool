package com.codechallenge.wc;

import com.codechallenge.wc.service.FileHandler;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.standard.ShellCommandGroup;

@Command(command = "ccwc", description = "CLI tool to get the word cound of a text file")
public class WordCountCmd {

    private final FileHandler fileHandler;

    public WordCountCmd(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Command
    public String ccwc(
            @Option(longNames = "c", shortNames = 'c', description = "outputs the number of bytes in a file") boolean c,
            @Option(longNames = "l", shortNames = 'l', description = "outputs the number of lines in a file") boolean l,
            @Option(longNames = "w", shortNames = 'w', description = "outputs the number of words in a file") boolean w,
            @Option(longNames = "m", shortNames = 'm', description = "outputs the number of characters in a file") boolean m,
            @Option(description = "File path") String filePath
    ){

        StringBuilder sb = new StringBuilder();

        if(c){
            sb.append(fileHandler.getByteCount(filePath));
        }

        if(l){
            sb.append(fileHandler.getLineCount(filePath));
        }

        if(w){
            sb.append(fileHandler.getWordCount(filePath));
        }

        if(m){
            sb.append(fileHandler.getCharCount(filePath));
        }

        return sb.toString();
    }

}
