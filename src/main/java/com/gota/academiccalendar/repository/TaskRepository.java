package com.gota.academiccalendar.repository;

import com.gota.academiccalendar.model.Status;
import com.gota.academiccalendar.model.Task;
import com.gota.academiccalendar.model.Type;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends ListCrudRepository<Task, Integer> {
	List<Task> findAllByTitleContains(String keyword);

	@Query("""
		SELECT * FROM task
		WHERE status = :status
	""")
	List<Task> findByStatus(@Param("status")Status status);

	List<Task> findByTaskType(Type type);
}