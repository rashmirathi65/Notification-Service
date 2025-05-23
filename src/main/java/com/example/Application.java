package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class Application
{
	//main method
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}