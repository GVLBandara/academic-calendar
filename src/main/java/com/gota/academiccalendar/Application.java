package com.gota.academiccalendar;

import com.gota.academiccalendar.model.Status;
import com.gota.academiccalendar.model.Task;
import com.gota.academiccalendar.model.Type;
import com.gota.academiccalendar.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(TaskRepository repository){
		return args -> {
			System.out.println("Hello world");
			Task t = new Task(null,
					"title",
					"desc",
					Status.SCHEDULED,
					Type.EXAM,
					LocalDateTime.now(),
					LocalDateTime.now(),
					null,
					"url");
			repository.save(t);
		};
	}

}
