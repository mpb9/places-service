package com.bb.places.controller;

import com.bb.places.model.User;
import com.bb.places.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
@Validated
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// GET REQUESTS
	@GetMapping(name = "Get User By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable @NotBlank String id) {
		logger.info("Entering UserController.getUserById...");

		User user = userService.getUserById(id);

		logger.info("\nUser: {}", user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping(name = "Get User By Email And Password", value = "/email/{email}/password/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable @NotNull String email,
			@PathVariable @NotNull String password) {
		logger.info("Entering UserController.getUserByEmailAndPassword...");

		User user = userService.getUserByEmailAndPassword(email, password);

		logger.info("\nUser: {}", user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@GetMapping(name = "Get Users By Name", value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsersByName(@PathVariable @NotNull String name) {
		logger.info("Entering UserController.getUsersByName...");

		List<User> userList = userService.getUsersByName(name);

		logger.info("\nUsers: {}", userList);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	@GetMapping(name = "Get All Users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("Entering UserController.getAllUsers...");

		List<User> userList = userService.getAllUsers();

		logger.info("\nUsers: {}", userList);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping(name = "Get Public Users", value = "/pblc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getPublicUsers() {
		logger.info("Entering UserController.getPublicUsers...");

		List<User> userList = userService.getPublicUsers();

		logger.info("\nUsers: {}", userList);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

// PUT REQUESTS
	@PutMapping(name = "Update User By ID", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUserById(
			@PathVariable @NotBlank String id,
			@Valid @NotNull @RequestBody User user) {
		logger.info("Entering UserController.updateUserById...");

		userService.updateUser(id, user);
		User userEnt = userService.getUserById(user.getId());

		logger.info("\nUser: {}", userEnt);
		return new ResponseEntity<>(userEnt, HttpStatus.OK);
	}

// POST REQUESTS
	@PostMapping(name = "Create User", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@Valid @NotNull @RequestBody User user) {
		logger.info("Entering UserController.createUser...");

		userService.createUser(user);
		User userEnt = userService.getUserById(user.getId());

		logger.info("\nUser: {}", userEnt);
		return new ResponseEntity<>(userEnt, HttpStatus.CREATED);
	}

// DELETE REQUESTS
	@DeleteMapping(name = "Delete User", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUser(@Valid @NotNull @RequestBody User user) {
		logger.info("Entering UserController.deleteUser...");

		userService.deleteUser(user);

		logger.info("User deleted: {}", user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
