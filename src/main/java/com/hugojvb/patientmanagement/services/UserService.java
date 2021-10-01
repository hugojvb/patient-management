package com.hugojvb.patientmanagement.services;

import com.hugojvb.patientmanagement.dto.UserRegistrationDto;
import com.hugojvb.patientmanagement.models.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
	public User saveUser(UserRegistrationDto userRegistrationDto);

	public User getUserByEmail(String email);
}
