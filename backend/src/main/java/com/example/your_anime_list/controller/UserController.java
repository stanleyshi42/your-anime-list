package com.example.your_anime_list.controller;

import com.example.your_anime_list.entity.AuthRequest;
import com.example.your_anime_list.entity.User;
import com.example.your_anime_list.service.JwtService;
import com.example.your_anime_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    // Authenticates login info and returns a JWT
    @PostMapping("/auth")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(authRequest.getUsername());
        else
            throw new UsernameNotFoundException("Error: Invalid user request");
    }

    @PostMapping()
    public ResponseEntity<Object> add(@RequestBody User user) {
        user.setRoles("ROLE_USER");
        User result;

        try {
            result = userService.add(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: Username already registered");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ArrayList<User> getAll() {
        return (ArrayList<User>) userService.findAll();
    }

    @GetMapping("/id/{id}")
    public User findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PutMapping()
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        userService.deleteById(id);
        return ResponseEntity.status(204).body(null);
    }

}
