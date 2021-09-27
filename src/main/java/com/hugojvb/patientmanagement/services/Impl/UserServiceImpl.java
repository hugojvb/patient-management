package com.hugojvb.patientmanagement.services.Impl;

import com.hugojvb.patientmanagement.dto.UserRegistrationDto;
import com.hugojvb.patientmanagement.models.User;
import com.hugojvb.patientmanagement.repositories.UserRepository;
import com.hugojvb.patientmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(UserRegistrationDto userRegistrationDto) {
		User newUser = new User();
		newUser.setName(userRegistrationDto.getName());
		newUser.setEmail(userRegistrationDto.getEmail());
		newUser.setPassword(userRegistrationDto.getPassword());
		return userRepository.save(newUser);
	}
}
