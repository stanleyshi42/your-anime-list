package com.example.your_anime_list.repository;

import com.example.your_anime_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Derived query
    Optional<User> findByUsername(String username);
}
