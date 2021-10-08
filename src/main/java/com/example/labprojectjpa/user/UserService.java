package com.example.labprojectjpa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User addUser(UserDTO userDto) {
        User user = User.builder()
                .userId(userDto.getUserId())
                .userPassword(userDto.getUserPassword())
                .build();
        userRepository.save(user);
        return user;
    }

    public User getUser(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("DB 조회 결과가 없습니다."));
        return user;
    }

    public String login(String userId, String userPassword) {
        Optional<User> user = userRepository.findByUserId(userId);
        if(user.get().getUserPassword().equals(userPassword)) {
            return "list";
        } else{
            return "login";
        }
    }


}
