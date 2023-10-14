package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.User;

import java.util.Optional;

public interface IRegistrationService {
    public User register(User _user);
    public Optional<User> findByUsername(String username);
    public Optional<User> findByEmailAddress(String emailAddress);
}
