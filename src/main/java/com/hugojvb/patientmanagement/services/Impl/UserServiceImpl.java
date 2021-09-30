package com.hugojvb.patientmanagement.services.Impl;

import java.util.ArrayList;
import java.util.List;

import com.hugojvb.patientmanagement.dto.UserRegistrationDto;
import com.hugojvb.patientmanagement.models.User;
import com.hugojvb.patientmanagement.repositories.UserRepository;
import com.hugojvb.patientmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	List<GrantedAuthority> role_name = new ArrayList<>();

	@Override
	public User saveUser(UserRegistrationDto userRegistrationDto) {
		User newUser = new User();
		newUser.setName(userRegistrationDto.getName());
		newUser.setEmail(userRegistrationDto.getEmail());
		newUser.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
		return userRepository.save(newUser);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("invalid email or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), role_name);
	}
}
