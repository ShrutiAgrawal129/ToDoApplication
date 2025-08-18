package com.td.entities;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Long userId;
	private String title;
	private String description;
	
	@Column(name="dueDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	private LocalDateTime reminderTime; // custom reminder time
	
	private boolean reminderSent = false; // to prevent duplicate emails
	
	@Column(name="status",columnDefinition = "int default 0")
	private boolean status;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

	public LocalDateTime getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(LocalDateTime reminderTime) {
		this.reminderTime = reminderTime;
	}

	
	public boolean isReminderSent() {
		return reminderSent;
	}

	public void setReminderSent(boolean reminderSent) {
		this.reminderSent = reminderSent;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Long userId, String title, String description, Date dueDate, LocalDateTime reminderTime,
			boolean reminderSent, boolean status) {
		super();
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.reminderTime = reminderTime;
		this.reminderSent = reminderSent;
		this.status = status;
	}

	

	

	

	
}
