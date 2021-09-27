package com.example.labprojectjpa.user;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String userPassword;
}
