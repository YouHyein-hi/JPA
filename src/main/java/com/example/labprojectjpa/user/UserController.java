package com.example.labprojectjpa.user;

import com.sun.istack.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> list = userService.getUserList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(UserDTO userDto) {
        User user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
