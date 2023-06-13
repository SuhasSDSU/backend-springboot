package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(path = "/create")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAll(){
        return userRepository.findAll();
    }
}
