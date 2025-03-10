package com.accenture.spring.user.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.accenture.spring.user.aop.Monitor;
import com.accenture.spring.user.domain.LogEntry;
import com.accenture.spring.user.domain.User;
import com.accenture.spring.user.repository.LogEntryRepository;
import com.accenture.spring.user.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final LogEntryRepository logEntryRepository;

	public UserServiceImpl(UserRepository userRepository, LogEntryRepository logEntryRepository) {
		this.userRepository = userRepository;
		this.logEntryRepository = logEntryRepository;
	}

	@Monitor
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PreAuthorize("isAuthenticated()")
	public User findUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@PreAuthorize("hasRole('ADMIN')")
	public User createUser(User user) {
		logEntryRepository.save(new LogEntry("User created"));
		return userRepository.save(user);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}