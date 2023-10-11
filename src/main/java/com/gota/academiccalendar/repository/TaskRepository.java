package com.gota.academiccalendar.repository;

import com.gota.academiccalendar.model.Task;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends ListCrudRepository<Task, Integer> {

}