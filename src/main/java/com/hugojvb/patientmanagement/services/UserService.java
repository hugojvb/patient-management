package com.hugojvb.patientmanagement.services;

import com.hugojvb.patientmanagement.dto.UserRegistrationDto;
import com.hugojvb.patientmanagement.models.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public User saveUser(UserRegistrationDto userRegistrationDto);
}
