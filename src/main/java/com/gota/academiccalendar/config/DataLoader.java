package com.gota.academiccalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gota.academiccalendar.model.Task;
import com.gota.academiccalendar.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader  implements CommandLineRunner {

	private final TaskRepository repository;
	private final ObjectMapper objectMapper;

	public DataLoader(TaskRepository repository, ObjectMapper objectMapper){
		this.repository = repository;
		this.objectMapper = objectMapper;
	}
	@Override
	public void run(String... args) throws Exception {
		if(repository.count()==0){
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/tasks.json")){
				repository.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Task>>(){}));
			}
		}
	}
}
