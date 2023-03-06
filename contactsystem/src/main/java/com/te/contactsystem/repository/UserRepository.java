package com.te.contactsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.te.contactsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByFirstName(String firstName);

	@Query("SELECT b FROM User b  WHERE " + "b.firstName LIKE CONCAT('%', :firstName, '%')")
	List<User> searchContactByFirstName(String firstName);
}
