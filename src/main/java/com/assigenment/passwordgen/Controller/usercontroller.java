package com.assigenment.passwordgen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assigenment.passwordgen.Model.user;
import com.assigenment.passwordgen.Services.userservice;


@RestController
@RequestMapping("/users")
public class usercontroller {
    
    @Autowired
    private userservice userService;

    // Add user endpoint
    @PostMapping("/add")
    public ResponseEntity<user> addUser(@RequestBody user userRequest) {
        user user = userService.createUser(
            userRequest.getFirstName(),
            userRequest.getMiddleName(),
            userRequest.getLastName()
        );
        return ResponseEntity.ok(user);
    }

    // Get all users endpoint
    @GetMapping("/all")
    public ResponseEntity<List<user>> getAllUsers() {
        List<user> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
