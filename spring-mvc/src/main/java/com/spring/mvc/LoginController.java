package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.model.User;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String redirectToLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String processLoginRequest(@RequestParam String email,ModelMap map){
		User user = new User();
		user.setFirstName(email);
		map.put("user",user);
		return "welcome";
	}

}
