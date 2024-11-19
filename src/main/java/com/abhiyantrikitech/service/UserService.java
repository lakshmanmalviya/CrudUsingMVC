package com.abhiyantrikitech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.abhiyantrikitech.dto.LoginRequest;
import com.abhiyantrikitech.dto.SignupRequest;
import com.abhiyantrikitech.dto.UserDto;
import com.abhiyantrikitech.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository authenticationRepository;

	public Optional<String> createUser(SignupRequest request, ModelMap model) {
		return authenticationRepository.createUser(request, model);
	}

	public UserDto loginUser(LoginRequest request, ModelMap model) {
		return authenticationRepository.loginUser(request, model);
	}

	public UserDto updateUser(UserDto userReq, ModelMap model) {
		return authenticationRepository.updateUser(userReq, model);
	}
}
