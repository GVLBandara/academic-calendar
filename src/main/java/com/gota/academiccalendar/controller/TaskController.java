package com.gota.academiccalendar.controller;

import com.gota.academiccalendar.model.Task;
import com.gota.academiccalendar.repository.TaskCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public Task findById(@PathVariable int id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Task task){
        repository.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Task task,@PathVariable int id){
        if(!repository.existById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found!");
        }
        if(task.id() != id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IDs does not match!");
        }
        repository.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.delete(id);
    }
}
