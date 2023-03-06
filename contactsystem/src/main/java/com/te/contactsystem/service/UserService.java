package com.te.contactsystem.service;

import java.util.List;

import com.te.contactsystem.dto.UserDto;
import com.te.contactsystem.entity.User;

public interface UserService {

	UserDto addUser(UserDto userDto);

	User searchUserByFirstName(String firstName);

	UserDto updateUser(UserDto userDto);

	Boolean deleteUser(Long userId);

	List<UserDto> getAllUsers();

}
