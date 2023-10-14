package com.example.fitnesstracker.Services.implementations;

import com.example.fitnesstracker.Entities.User;
import com.example.fitnesstracker.Repositories.UserRepository;
import com.example.fitnesstracker.Services.interfaces.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RegistrationService implements IRegistrationService {
    private final UserRepository userRepository;

    private final Logger logger = Logger.getLogger(RegistrationService.class.getName());

    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public User register(User _user) {
        User user = null;
        if (_user == null)
            logger.log(Level.SEVERE, "entity must not be null");
        else {
            try {
                user = userRepository.save(_user);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to create user by username: " + _user.getUsername());
            }
        }

        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<User> findByUsername(String username) {
        Optional<User> userOptional = Optional.empty();
        if (username == null || username.trim().isEmpty())
            logger.log(Level.SEVERE, "username cannot be null");
        else {
            try {
                userOptional = userRepository.findByUsername(username);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to find user by username: " + username);
            }
        }

        return userOptional;
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<User> findByEmailAddress(String emailAddress) {
        Optional<User> userOptional = Optional.empty();
        if (!EmailValidatorService.isEmailValid(emailAddress))
            logger.log(Level.SEVERE, "emailAddress cannot be null");
        else {
            try {
                userOptional = userRepository.findByUsername(emailAddress);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to find user by email Address: " + emailAddress);
            }
        }

        return userOptional;
    }
}
