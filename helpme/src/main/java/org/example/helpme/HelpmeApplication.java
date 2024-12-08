package org.example.helpme;

import org.example.helpme.repositories.AnswerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelpmeApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelpmeApplication.class, args);
	}

}
