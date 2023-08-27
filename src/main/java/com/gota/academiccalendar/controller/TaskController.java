package com.gota.academiccalendar.controller;

import com.gota.academiccalendar.model.Task;
import com.gota.academiccalendar.repository.TaskCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskCollectionRepository repository;

    public TaskController(TaskCollectionRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")
    public List<Task> findAll(){
        return repository.findAll();
    }
}
