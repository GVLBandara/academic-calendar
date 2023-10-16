package com.gota.academiccalendar.controller;

import com.gota.academiccalendar.model.Status;
import com.gota.academiccalendar.model.Task;
import com.gota.academiccalendar.model.Type;
import com.gota.academiccalendar.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@CrossOrigin
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
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
    public void create(@Valid @RequestBody Task task){
        repository.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Task task,@PathVariable int id){
        if(!repository.existsById(id)){
            System.out.println("1");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found!");
        }
        if(task.id() != id){
            System.out.println("2");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IDs does not match!");
        }
        System.out.println("3");
        repository.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("/filter/title/{keyword}")
    public List<Task> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Task> findByStatus(@PathVariable Status status){
        return repository.findByStatus(status);
    }

    @GetMapping("/filter/type/{type}")
    public List<Task> findByType(@PathVariable Type type){
        return repository.findByTaskType(type);
    }
}
