package com.hugojvb.patientmanagement.controllers;

import com.hugojvb.patientmanagement.dto.UserRegistrationDto;
import com.hugojvb.patientmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UserRegistration {

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String regusterUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		userService.saveUser(userRegistrationDto);

		return "redirect:/registration?success";
	}

}
