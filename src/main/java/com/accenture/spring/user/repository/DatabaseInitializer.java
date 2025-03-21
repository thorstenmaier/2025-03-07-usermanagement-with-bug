package com.accenture.spring.user.repository;

import java.util.Arrays;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.spring.user.domain.User;

@Component
public class DatabaseInitializer {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void fillDatabase() {
		userRepository.saveAll(Arrays.asList(new User("Guenther", "Nubert"), new User("Bud", "Spencer"),
				new User("Dieter", "Develop")));
	}
}