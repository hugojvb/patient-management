package com.hugojvb.patientmanagement.controllers;

import com.hugojvb.patientmanagement.dto.UserRegistrationDto;
import com.hugojvb.patientmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/registration")
public class UserRegistration {

	@Autowired
	private UserService userService;

	@GetMapping
	public String showRegistrationForm(Model model) {
		return "registration";
	}

	@PostMapping
	public String registerUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		userService.saveUser(userRegistrationDto);

		return "redirect:/registration?success";
	}

}
