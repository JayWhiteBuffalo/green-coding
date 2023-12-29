package org.launchcode.greencoding.TravelUp.controllers;

import org.launchcode.greencoding.TravelUp.models.Post;
import org.launchcode.greencoding.TravelUp.models.Users;
import org.launchcode.greencoding.TravelUp.models.data.PostRepository;
import org.launchcode.greencoding.TravelUp.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        // Perform validation and error handling as needed
        usersRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId) {
        Optional<Users> user = usersRepository.findById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create-post")
    public ResponseEntity<String> createPost(@RequestParam Long userId, @RequestBody Post post) {
        // Perform validation and error handling as needed
        Optional<Users> user = usersRepository.findById(userId);
        if (user.isPresent()) {
            post.setUser(user.get());
            postRepository.save(post);
            return ResponseEntity.ok("Post created successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add more methods for handling other functionalities like rating posts, commenting, following, etc.

}
