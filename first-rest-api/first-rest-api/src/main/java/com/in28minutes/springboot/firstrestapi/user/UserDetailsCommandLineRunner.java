package com.in28minutes.springboot.firstrestapi.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(getClass());

	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	private UserDetailsRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new UserDetails("Jordan", "Admin"));
		repository.save(new UserDetails("Michael", "Admin"));
		repository.save(new UserDetails("Billy", "Admin"));
		
		//List<UserDetails> users = repository.findAll();
		
		List<UserDetails> users = repository.findByRole("Admin");
		users.forEach(user -> logger.info(user.toString()));
	}
}
