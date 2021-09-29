package com.hugojvb.patientmanagement.services.Impl;

import com.hugojvb.patientmanagement.dto.UserRegistrationDto;
import com.hugojvb.patientmanagement.models.User;
import com.hugojvb.patientmanagement.repositories.UserRepository;
import com.hugojvb.patientmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("invalid email or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);
	}
}
