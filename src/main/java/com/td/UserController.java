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
@RequestMapping("/user")
public class UserController {
	
	HttpSession hs;
	@Autowired
	private UserServices userServ;
	
	@GetMapping("/")
	private String index() {
		return "user/user_index";
	}
	
	@GetMapping("/user_index")
	private String indexx() {
		return "user/user_index";
	}
	
	@GetMapping("/profile")
	private String profile(Model model,HttpServletRequest request) {
		hs = request.getSession(false);
		String name=(String) hs.getAttribute("uname");
		if(name==null) {
			return "redirect:/logIn";
		}else {
			User user=userServ.profile(name);
			model.addAttribute("userAtt", user);
			return "user/profile";
		}
	}
	
	@PostMapping("/profile")
	private String profilee(Model model,HttpServletRequest request) {
		String action1=request.getParameter("eprofile");
		String action2=request.getParameter("cpassword");
		if("Edit Profile".equals(action1)) {
			return "user/edit_profile";
		}
		if("Change Password".equals(action2)) {
			return "user/change_password";
		}
		
		return null;
	}
	
	@RequestMapping("/edit_profile")
	private String eprofilee(@RequestParam("email")String email,HttpServletRequest request
			,Model model) {
		hs = request.getSession(false);
		String sname=(String) hs.getAttribute("uname");
		if(sname==null) {
			return "redirect:/logIn";
		}else {
			userServ.eprofile(sname, email);
			User u=userServ.profile(sname);
			model.addAttribute("userAtt",u);
			return "user/profile";
		}
	}
	
	@RequestMapping("/change_password")
	private String changep(@RequestParam("opass")String opass,
			@RequestParam("n1pass")String n1pass,@RequestParam("n2pass")String n2pass,
			HttpServletRequest request,Model model) {
		hs = request.getSession(false);
		String sname=(String) hs.getAttribute("uname");
		if(sname==null) {
			return "redirect:/logIn";
		}
		else {
			User user=userServ.profile(sname);
			String oldp=user.getPassword();
			if(oldp.equals(opass) && n1pass.equals(n2pass)){
				userServ.cpass(sname, n2pass);
				User u=userServ.profile(sname);
				model.addAttribute("userAtt",u);
				return "user/profile";
			}else {
				return "user/change_password";
			}	
		}	
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpServletRequest request) {
		hs=request.getSession(false);
		if(hs!= null) {
			hs.invalidate();
			hs=null;
			return "redirect:/logIn";
		}
		return null;
	}
}
