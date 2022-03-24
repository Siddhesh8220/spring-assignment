package com.springboot.assignment.controllers;

import java.util.*;
import com.springboot.assignment.entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class UserController {

    ArrayList<User> users = new ArrayList<>();

    void populateUsers() {
        users.add(new User("Siddhesh chavan", "siddhesh8220@gmail.com", "123456789"));
        users.add(new User("Rohan Sawant","rohansawant@gmail.com","123456789"));
    }

    UserController(){
        populateUsers();
    }

    @GetMapping(path="/users")
    public ArrayList<User> getAllUsers() {
        return users;
    }


    @PostMapping(path="/register")
    public ResponseEntity<?> register(@RequestBody User ob){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json");
        for(User user:users) {
            if(user.getEmail().equals(ob.getEmail())) {
                return new ResponseEntity<String>("User already exists!", responseHeaders, HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        users.add(ob);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", ob.getUsername());
        map.put("email", ob.getEmail());
        return new ResponseEntity<Object>(map, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> login(@RequestBody User ob){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json");
        for(User user:users) {
            if(user.getEmail().equals(ob.getEmail()) && user.getPassword().equals(ob.getPassword())) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("username", ob.getUsername());
                map.put("email", ob.getEmail());
                return new ResponseEntity<Object>(map, responseHeaders, HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<String>("User not found!", responseHeaders, HttpStatus.NOT_FOUND);
    }
}
