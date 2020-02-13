package com.ust.user.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.NumberUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.response.SingleResponse;
import com.ust.user.service.UserService;
import com.ust.user.service.bo.UserBO;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<SingleResponse<UserBO>> create(HttpServletRequest request, @RequestBody UserBO user,
			BindingResult result) {
		SingleResponse<UserBO> response = new SingleResponse<UserBO>();
		try {
			validateCreateUser(user, result);
			if (result.hasErrors()) {
				List<String> errors = new ArrayList<String>();
				for (ObjectError error : result.getAllErrors()) {
					errors.add(error.getDefaultMessage());
				}
				response.setErrors(errors);
				return ResponseEntity.badRequest().body(response);
			}

			user.setPassword(passwordEncoder.encode(user.getPassword()));
			UserBO userPersisted = (UserBO) this.userService.saveUser(user);
			response.setData(userPersisted);
		} catch (DuplicateKeyException d) {
			response.getErrors().add("Email already registered");
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}

	public void validateCreateUser(UserBO user, BindingResult result) {
		if (user.getEmail() == null) {
			result.addError(new ObjectError("User", "Email not informed"));
		}
	}

	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<SingleResponse<UserBO>> update(HttpServletRequest request, @RequestBody UserBO user,
			BindingResult result) {
		SingleResponse<UserBO> response = new SingleResponse<UserBO>();
		try {
			validateUpdateUser(user, result);
			if (result.hasErrors()) {
				List<String> errors = new ArrayList<String>();
				for (ObjectError error : result.getAllErrors()) {
					errors.add(error.getDefaultMessage());
				}
				response.setErrors(errors);
				return ResponseEntity.badRequest().body(response);
			}
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			UserBO userUpdated = (UserBO) this.userService.saveUser(user);
			response.setData(userUpdated);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	public void validateUpdateUser(UserBO user, BindingResult result) {
		if (user.getId() == null) {
			result.addError(new ObjectError("User", "Id not informed"));
		}
		if (user.getEmail() == null) {
			result.addError(new ObjectError("User", "Email not informed"));
		}
	}

	@GetMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<SingleResponse<UserBO>> findById(@PathVariable("id") String id) {
		SingleResponse<UserBO> response = new SingleResponse<UserBO>();
		Integer iId = NumberUtils.parseNumber(id, Integer.class);
		UserBO user = this.userService.findById(iId);
		if (user == null) {
			response.getErrors().add("Register not found id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(user);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<SingleResponse<String>> delete(@PathVariable("id") String id) {
		SingleResponse<String> response = new SingleResponse<String>();
		Integer iId = NumberUtils.parseNumber(id, Integer.class);
		UserBO user = this.userService.findById(iId);
		if (user == null) {
			response.getErrors().add("Register not found id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		this.userService.delete(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<SingleResponse<Page<UserBO>>> findAll(@PathVariable int page, @PathVariable int count) {
		SingleResponse<Page<UserBO>> response = new SingleResponse<Page<UserBO>>();
		Page<UserBO> users = this.userService.findAll(page, count);
		response.setData(users);
		return ResponseEntity.ok(response);
	}
}