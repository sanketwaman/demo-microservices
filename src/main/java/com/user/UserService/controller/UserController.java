package com.user.UserService.controller;

import com.user.UserService.entity.User;
import com.user.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){

       User user=this.service.getUser(userId);
       //http://localhost:9002/contact/user/1311

        List contacts = this.restTemplate.getForObject("http://CONTACT-SERVICE/contact/user/"+user.getUserId(),List.class);

        user.setContacts(contacts);
        return user;
    }
}
