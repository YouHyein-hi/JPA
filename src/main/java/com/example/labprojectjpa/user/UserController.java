package com.example.labprojectjpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> list = userService.getUserList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /*로그인 컨트롤러?*/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /*로그인 체크 기능*/
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        if(userService.login(userDTO.getUserId(), userDTO.getUserPassword()).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public String signIn(String inputUserId, String inputUserPassword) {
        User user = userRepository.findByUserIdAndUserPassword(inputUserId, inputUserPassword).orElseThrow(()->new RuntimeException("DB 조회 실패"));
        if (user != null) {
            return "list";
        }
        return "login";
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