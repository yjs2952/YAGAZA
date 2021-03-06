package com.spring.yagaza.web.controller;

import com.spring.yagaza.web.domain.User;
import com.spring.yagaza.web.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public String login(@ModelAttribute User user, Model model){

		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}

	@ResponseBody
	@PostMapping("/join")
	public ResponseEntity<?> join(@Valid User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()){
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(userService.userAdd(user));
	}

	@ResponseBody
	@GetMapping("/idCheck")
	public ResponseEntity<?> idCheck(String userId) {
		System.out.println("userId : " + userId);

		try {
			return ResponseEntity.ok(userService.idCheck(userId));
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}