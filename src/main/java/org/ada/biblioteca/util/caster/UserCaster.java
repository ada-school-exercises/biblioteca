package org.ada.biblioteca.util.caster;

import org.ada.biblioteca.bo.postgres.UserPostgres;
import org.ada.biblioteca.dto.user.UserRequest;
import org.ada.biblioteca.dto.user.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserCaster {
    public UserResponse userToUserResponse(UserPostgres user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setDateCreation(user.getDateCreation());
        userResponse.setDateUpdate(user.getDateUpdate());
        return userResponse;
    }

    public UserPostgres userRequestToUser(UserRequest userRequest) {
        UserPostgres user = new UserPostgres();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setDateCreation(LocalDateTime.now());
        user.setDateUpdate(LocalDateTime.now());
        return user;
    }
}
