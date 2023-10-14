package com.example.fitnesstracker.Repositories;

import com.example.fitnesstracker.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    Optional<User> findByEmailAddress(String emailAddress);
    Optional<User> findByUsername(String username);
    void deleteById(Long id);
}
