package com.td.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.td.entities.Task;
import com.td.repository.TaskRepository;

@Service
public class TaskServices {

	@Autowired
	private TaskRepository taskRepo;

	public void add(Task task) {
		taskRepo.save(task);
	}

	public List<Task> findByUId(Long u_id) {
		System.out.println(u_id);
		return taskRepo.findByUserId(u_id);
	}

	@Transactional
	public void markStatusTrue(Long Id) {
	    taskRepo.updateStatus(Id);
	}
	
	public Task findByTId(Long Id) {
	    return taskRepo.findById(Id).orElse(null);
	}

	@Transactional
	public void deleteById(Long Id) {
		taskRepo.deleteById(Id);
	}
	
	@Transactional
	public void edit(Long Id,String title,String description,Date dueDate) {
		taskRepo.editTask(Id,title,description,dueDate);
	}
}
