package com.agrect_backend.service;

import com.agrect_backend.model.user.User;
import com.agrect_backend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BeanUtilsService beanUtilsService;

    public User registerUser(User user){
        if (userRepository.findByPhone(user.getPhone()).isPresent()){
            throw new RuntimeException("This phone number Is already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id ,User updateUser){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        BeanUtils.copyProperties(updateUser, existingUser, beanUtilsService.getNullPropertyNames(updateUser));

        return userRepository.save(existingUser);
    }
    public void deleteUser(long id){
            User user = userRepository.findById(id).get();
            user.setCurrent_status(false);
            userRepository.save(user);

        }


    }

