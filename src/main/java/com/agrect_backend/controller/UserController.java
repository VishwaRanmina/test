package com.agrect_backend.controller;

import com.agrect_backend.model.user.User;
import com.agrect_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try{
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok("User Registered Successfully! ID: "+ newUser.getId());

        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        try{
            return ResponseEntity.ok("User Registered Successfully! ID: ");

        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){

        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("User Deleted Successfully!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id , @RequestBody User user ){
        try {
            return ResponseEntity.ok(userService.updateUser(id,user));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
