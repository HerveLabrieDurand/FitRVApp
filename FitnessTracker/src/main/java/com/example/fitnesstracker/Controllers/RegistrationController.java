package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Services.interfaces.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.fitnesstracker.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/registration/")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User _user) {
        User user = this.registrationService.register(_user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/username")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) {
        Optional<User> userOptional = registrationService.findByUsername(username);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/emailAddress")
    public ResponseEntity<User> getExerciseById(@RequestParam String emailAddress) {
        Optional<User> userOptional = registrationService.findByEmailAddress(emailAddress);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
