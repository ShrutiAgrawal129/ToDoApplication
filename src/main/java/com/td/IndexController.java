package com.td;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.td.entities.User;
import com.td.services.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	HttpSession hs; 
	
	@Autowired
	private UserServices userServ;
	
	@RequestMapping("/")
	private String index() {
		return "index";
	}
	
	@RequestMapping("/index")
	private String ind() {
		return "index";
	}
	
	@GetMapping("/register")
	private String regg() {
		return "register";
	}
	
	@PostMapping("/register")
	private String reg(User user) {
		userServ.saveUser(user);
		return "index";
	}
	
	@GetMapping("/logIn")
	private String log(HttpServletRequest request) {
		hs=request.getSession(false);
		if(hs!= null) {
			hs.invalidate();
			hs=null;
			return "logIn";
		}
		return null;
	}
	
	@RequestMapping("/logIn")
	private String logg(@RequestParam("name")String name,@RequestParam("password")String password,
			HttpServletRequest request,Model model) {
		
		hs=request.getSession(false);
		if(hs!=null) {
			hs.invalidate();
			hs=null;
		}
		hs=request.getSession(true);
	
		boolean r=userServ.checkUser(name, password);
		if(r) {
			hs.setAttribute("uname", name);
			return "redirect:/user/user_index";
		}else {
			return "logIn";
		}
		
	}
	
	
}
