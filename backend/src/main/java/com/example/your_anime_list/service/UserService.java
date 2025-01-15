package com.example.your_anime_list.service;

import com.example.your_anime_list.entity.MyUserDetails;
import com.example.your_anime_list.entity.User;
import com.example.your_anime_list.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    public User update(User user) {
        return userRepo.save(user);
    }

    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElse(null);

        if (user == null)
            throw new UsernameNotFoundException(username);
        return new MyUserDetails(user);
    }
}
