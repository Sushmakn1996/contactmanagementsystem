package com.te.contactsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.contactsystem.dto.Response;
import com.te.contactsystem.dto.UserDto;
import com.te.contactsystem.entity.User;
import com.te.contactsystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public ResponseEntity<Response> addUser(@RequestBody UserDto userDto) {
		UserDto details = service.addUser(userDto);
		if (details != null) {
			return ResponseEntity.accepted().body(new Response(false, details, "Added Successfully", HttpStatus.OK));
		}
		return ResponseEntity.badRequest().body(new Response(true, null, "Not Added", HttpStatus.BAD_REQUEST));
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<Response> updateUserContactDetails(@RequestBody UserDto userDto) {
		UserDto updateUserContactDetails = service.updateUser(userDto);
		if (updateUserContactDetails != null) {
			return ResponseEntity.accepted()
					.body(new Response(false, updateUserContactDetails, "Updated  Successfully", HttpStatus.OK));
		}
		return ResponseEntity.badRequest().body(new Response(true, null, "Not Updated", HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<Response> deleteUserContactDetails(@PathVariable Long userId) {
		Boolean deleteUserContactDetails = service.deleteUser(userId);
		if (deleteUserContactDetails != null) {
			return ResponseEntity.accepted()
					.body(new Response(false, deleteUserContactDetails, "Deleted   Successfully", HttpStatus.OK));
		}
		return ResponseEntity.badRequest().body(new Response(true, null, "Not Deleted", HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/searchUserByFirstName/{firstName}")
	public ResponseEntity<Response> searchUserByFirstName(@PathVariable String firstName) {
		User user = service.searchUserByFirstName(firstName);
		if (user != null) {
			return ResponseEntity.accepted()
					.body(new Response(false, user, "Fetched Successfully", HttpStatus.OK));
		}
		return ResponseEntity.badRequest().body(new Response(true, null, "Not Added", HttpStatus.BAD_REQUEST));
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/getAllUsers")
	public ResponseEntity<Response> getAllUserContactDetails() {
		List<UserDto> allUserContactDetails = service.getAllUsers();
		if (!allUserContactDetails.isEmpty()) {
			return ResponseEntity.accepted()
					.body(new Response(false, allUserContactDetails, "List Fetched Successfully", HttpStatus.ACCEPTED));
		}
		return ResponseEntity.badRequest()
				.body(new Response(true, null, "List of User Contact Details Is Empty", HttpStatus.BAD_GATEWAY));
	}
}
