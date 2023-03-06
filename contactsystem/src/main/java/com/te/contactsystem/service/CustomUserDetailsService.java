package com.te.contactsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.te.contactsystem.entity.User;
import com.te.contactsystem.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> findByFirstName = repository.findByFirstName(username);
		User user = findByFirstName.get();
		return new MyUserDetails(user);
	}
}