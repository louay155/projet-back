package com.bezkoder.spring.security.postgresql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.security.postgresql.models.Seance;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import com.bezkoder.spring.security.postgresqlNotFoundException.RessourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("getUserByid/{id}")
	public ResponseEntity<User> getUserByid(@PathVariable long id)
	{
		User user = userRepository.findById(id).
				orElseThrow(()->  new RessourceNotFoundException("seance does not exist with this id:"+id));
		return ResponseEntity.ok(user);
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateseance(@PathVariable long id , @RequestBody User userDetails)
		{
			User user= userRepository.findById(id).
					orElseThrow(()->  new RessourceNotFoundException("user does not exist with this id:"+id));
			user.setAdress(userDetails.getAdress());
			User updateUser=userRepository.save(user);
			return ResponseEntity.ok(updateUser);
		}

}
