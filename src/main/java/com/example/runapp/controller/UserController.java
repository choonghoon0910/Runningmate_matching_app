package com.example.runapp.controller;

import com.example.runapp.entity.User;
import com.example.runapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(updatedUser.getUsername());
            user.setAge(updatedUser.getAge());
            user.setGender(updatedUser.getGender());
            return userRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
