package org.ada.biblioteca.util.caster;

import org.ada.biblioteca.bo.User;
import org.ada.biblioteca.bo.mongo.UserMongo;
import org.ada.biblioteca.bo.postgres.UserPostgres;
import org.ada.biblioteca.dto.user.UserRequest;
import org.ada.biblioteca.dto.user.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserCaster {

    public UserPostgres userToUserPostgres(User user) {
        UserPostgres userPostgres = new UserPostgres();
        userPostgres.setId(Long.parseLong(user.getId()));
        userPostgres.setName(user.getName());
        userPostgres.setUsername(user.getUsername());
        userPostgres.setEmail(user.getEmail());
        userPostgres.setPassword(user.getPassword());
        userPostgres.setDateCreation(user.getDateCreation());
        userPostgres.setDateUpdate(user.getDateUpdate());
        return userPostgres;
    }

    public User userPostgresToUser(UserPostgres userPostgres) {
        User user = new User();
        user.setId(String.valueOf(userPostgres.getId()));
        user.setName(userPostgres.getName());
        user.setUsername(userPostgres.getUsername());
        user.setEmail(userPostgres.getEmail());
        user.setPassword(userPostgres.getPassword());
        user.setDateCreation(userPostgres.getDateCreation());
        user.setDateUpdate(userPostgres.getDateUpdate());
        return user;
    }

    public UserMongo userToUserMongo(User user) {
        UserMongo userMongo = new UserMongo();
        userMongo.setId(user.getId());
        userMongo.setName(user.getName());
        userMongo.setUsername(user.getUsername());
        userMongo.setEmail(user.getEmail());
        userMongo.setPassword(user.getPassword());
        userMongo.setDateCreation(user.getDateCreation());
        userMongo.setDateUpdate(user.getDateUpdate());
        return userMongo;
    }

    public User userMongoToUser(UserMongo userMongo) {
        User user = new User();
        user.setId(userMongo.getId());
        user.setName(userMongo.getName());
        user.setUsername(userMongo.getUsername());
        user.setEmail(userMongo.getEmail());
        user.setPassword(userMongo.getPassword());
        user.setDateCreation(userMongo.getDateCreation());
        user.setDateUpdate(userMongo.getDateUpdate());
        return user;
    }

    public UserResponse userToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setDateCreation(user.getDateCreation());
        userResponse.setDateUpdate(user.getDateUpdate());
        return userResponse;
    }
}
