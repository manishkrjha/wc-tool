package com.codechallenge.wc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan
public class WcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WcApplication.class, args);
	}

}
