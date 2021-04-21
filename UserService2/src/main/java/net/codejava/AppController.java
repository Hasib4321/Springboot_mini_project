package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RequestRepository reqRepo;
	
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
		
		model.addAttribute("request", new Request());
		
		return "users";
	}
	
	
	@GetMapping("/changepwd")
	public String changePassword(Model model) {
		model.addAttribute("user", new User());
		
		return "changepwd";
	}
	
	@PostMapping("/updatepwd")
	public String updatePassword(User user) {
//	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	String encodedPassword = passwordEncoder.encode(user.getPassword());
//	user.setPassword(encodedPassword);
	userRepo.save(user);
	
	return "index";
	
	}
	
	@PostMapping("/requestSubmit")
	public String requestSaved(Request request) {
		
		reqRepo.save(request);
		
		return "index";
	}
	
	@GetMapping("/requestList")
	public String requestDisplay(Model model) {
		List<Request> listrequest = reqRepo.findAll();
		model.addAttribute("listrequest", listrequest);
		
		return "requestList";
	}
	
}

