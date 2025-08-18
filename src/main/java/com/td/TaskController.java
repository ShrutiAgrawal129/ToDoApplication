package com.td;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.td.entities.Task;
import com.td.entities.User;
import com.td.services.TaskServices;
import com.td.services.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/task")
public class TaskController {

	HttpSession hs;

	@Autowired
	private TaskServices taskServ;

	@Autowired
	private UserServices userServ;

	@GetMapping("/add_task")
	private String addT() {
		return "task/add_task";
	}

	@PostMapping("/add_task")
	private String addTT(Task task, HttpServletRequest request) {
		hs = request.getSession(false);
		String sname = (String) hs.getAttribute("uname");
		if (sname == null) {
			return "redirect:/logIn";
		} else {
			User user = userServ.profile(sname);
			task.setUserId(user.getU_id());
			taskServ.add(task);
		}
		return "task/add_task";
	}

	@GetMapping("/view_tasks")
	private String view(HttpServletRequest request, Model model) {
		hs = request.getSession(false);
		String sname = (String) hs.getAttribute("uname");
		if (sname != null) {
			User user = userServ.profile(sname);
			System.out.println(user.getU_id());
			List<Task> tasks = taskServ.findByUId(user.getU_id());
			System.out.println(tasks);
			model.addAttribute("tasks", tasks);
		} else {
			System.out.println("Error");
		}
		return "task/view_tasks";
	}

	@PostMapping("/view_tasks")
	private String update(HttpServletRequest request,@RequestParam("Id") Long Id,Model model) {
		hs = request.getSession(false);
		String sname = (String) hs.getAttribute("uname");
		if (Id != null) {
			taskServ.markStatusTrue(Id);
			User user = userServ.profile(sname);
			System.out.println(user.getU_id());
			List<Task> tasks = taskServ.findByUId(user.getU_id());
			System.out.println(tasks);
			model.addAttribute("tasks", tasks);
			
		}else {
			System.out.println("No id found");
		}
		return "task/view_tasks";
	}

	@RequestMapping("/update_task")
	public String editt(HttpServletRequest request, @RequestParam("Id") Long Id, Model model) {
		hs = request.getSession(false);
		String sname = (String) hs.getAttribute("uname");
		User user = userServ.profile(sname);
//		System.out.println(user.getU_id());
		String editb = request.getParameter("edit");
		String deleteb = request.getParameter("delete");
		if ("Edit".equals(editb)) {
			Task task = taskServ.findByTId(Id);
	        model.addAttribute("task", task);
			return "task/edit_task";
			
		} else if ("Delete".equals(deleteb)) {
			taskServ.deleteById(Id);
		} 		
		List<Task> tasks = taskServ.findByUId(user.getU_id());
//		System.out.println(tasks);
		model.addAttribute("tasks", tasks);
		return "task/view_tasks";
	}
	
	@RequestMapping("/editTask")
	public String edittt(HttpServletRequest request,Model model,@RequestParam("title")String title,
			@RequestParam("description")String description,@RequestParam("Id")Long Id,@RequestParam("dueDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dueDate) {
		hs = request.getSession(false);
		String sname = (String) hs.getAttribute("uname");
		User user = userServ.profile(sname);
//		System.out.println(tasks);
		taskServ.edit(Id,title,description,dueDate);
		List<Task> tasks = taskServ.findByUId(user.getU_id());
		model.addAttribute("tasks", tasks);
		return "task/view_tasks";
	}
	
}
