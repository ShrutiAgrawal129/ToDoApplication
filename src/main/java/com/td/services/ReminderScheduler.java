package com.td.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.td.entities.Task;
import com.td.entities.User;
import com.td.repository.TaskRepository;
import com.td.repository.UserRepository;

@Service
public class ReminderScheduler {
	@Autowired
    private TaskRepository taskRepository;

	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRate = 60000) // check every 1 minute
    public void sendScheduledReminders() {
        LocalDateTime now = LocalDateTime.now();

        List<Task> dueReminders = taskRepository.findByReminderTimeBeforeAndReminderSentFalse(now);
        for (Task task : dueReminders) {
        	User user = userRepository.findById(task.getUserId()).orElse(null);
        	if (user != null) {
        	    emailService.sendReminder(
        	        user.getEmail(),
        	        "Reminder: " + task.getTitle(),
        	        "Hi " + user.getName() + ",\n\nYour task \"" + task.getTitle() +
        	        "\" is due on " + task.getDueDate() + ".\n\nReminder sent as scheduled."
        	    );

        	    task.setReminderSent(true);
        	    taskRepository.save(task);
        	}
        }
    }
}
