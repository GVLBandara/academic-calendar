package com.gota.academiccalendar.repository;

import com.gota.academiccalendar.model.Status;
import com.gota.academiccalendar.model.Task;
import com.gota.academiccalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskCollectionRepository {
    private final List<Task> taskList = new ArrayList<>();

    public TaskCollectionRepository() {
    }

    public List<Task> findAll() {
        return taskList;
    }

    public Optional<Task> findById(Integer id) {
        return taskList.stream().filter(c-> c.id().equals(id)).findFirst();
    }

    public void save(Task task){
        taskList.add(task);
    }

    @PostConstruct
    private void init() {
        Task t = new Task(1,
                "name",
                "desc",
                Status.SCHEDULED,
                Type.EXAM,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                "url");
        taskList.add(t);
    }
}
