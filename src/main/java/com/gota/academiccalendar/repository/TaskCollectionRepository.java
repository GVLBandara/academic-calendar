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
    private final List<Task> task = new ArrayList<>();

    public TaskCollectionRepository() {
    }

    public List<Task> findAll() {
        return task;
    }

    public Optional<Task> findById(Integer id) {
        return task.stream().filter(c-> c.id().equals(id)).findFirst();
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
        task.add(t);
    }
}
