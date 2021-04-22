package com.src.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RequestRepository reqRepo;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		//User user = (User) session.getAttribute("user");
		model.addAttribute("request", new Request());
		
		return "users";
	}
	
	
	@GetMapping("/changepwd")
	public String changePassword(Model model) {
		model.addAttribute("user", new User());
		
		return "changepwd";
	}
	
//	@PostMapping("/updatepwd")
//	public String updatePassword(User user) {
//	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	String encodedPassword = passwordEncoder.encode(user.getPassword());
//	user.setPassword(encodedPassword);
//	userRepo.save(user);
//	
//	return "index";
//	
//	}
	
//	@PostMapping("/requestSubmit")
//	public String requestSaved(Request request) {
//	
//		reqRepo.save(request);
//		
//		
//		return "index";
//	}
	
	@PostMapping("/requestSubmit")
	public String requestSaved(@ModelAttribute Request request,ModelMap model)
	{
		reqRepo.save(request);
		model.addAttribute("claimNumber",request.getClaimNumber());
		model.addAttribute("category",request.getCategory());
		model.addAttribute("amount",request.getAmount());
		model.addAttribute("fromDate",request.getFromDate());
		model.addAttribute("toDate",request.getToDate());
		
		return "requestList";
		
	}
	
//	@GetMapping("/requestList")
//	public String requestDisplay(Model model) {
//		List<Request> listrequest = reqRepo.findAll();
//		model.addAttribute("listrequest", listrequest);
//		
//		return "requestList";
//	}
	
//	@PostMapping("/updatepwd")
//	public String changePassword(Model model,HttpSession session,@RequestParam("oldPassword") String oldPass,@RequestParam("newPassword") String newPass) {
//	User user = (User) session.getAttribute("user");
//	if(user.getPassword().equals(oldPass)) {
//	user.setPassword(newPass);
//	userRepo.save(user);
//	return "index";
//	}else {
//	model.addAttribute("failmsg", "Old Password does not match");
//	return "updatepwd";
//	}
//	}
	
	
	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model, User user) {
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("password");
	     
	   
	    //model.addAttribute("title", "Reset your password");
	    userService.updatePassword(user,oldpassword,newpassword);
	    //model.addAttribute("message", "You have successfully changed your password.");
	   
	    return "resetSuccess";
	}
	}