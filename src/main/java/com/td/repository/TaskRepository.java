package com.td.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.td.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByUserId(Long userId);
	
	List<Task> findByReminderTimeBeforeAndReminderSentFalse(LocalDateTime now);

	@Modifying
	@Query("UPDATE Task t SET t.status=true WHERE t.Id=:Id")
	void updateStatus(@Param("Id")Long Id);
	
	@Modifying
	@Query("DELETE Task t WHERE t.Id=:Id")
	void deleteTask(@Param("Id")Long Id);
	
	@Modifying
	@Query("UPDATE Task t SET t.title=:title, t.description=:description, t.dueDate=:dueDate WHERE t.Id=:Id")
	void editTask(@Param("Id")Long Id,@Param("title")String title
			,@Param("description")String description,@Param("dueDate")Date dueDate);
}
