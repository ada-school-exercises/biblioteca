package org.ada.biblioteca.service.user;

import org.ada.biblioteca.dto.user.UserRequest;
import org.ada.biblioteca.dto.user.UserRequestUpdate;
import org.ada.biblioteca.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();
    UserResponse findUserById(Long idUser);
    UserResponse updateUser(Long idUser, UserRequestUpdate userRequestUpdate);
    void deleteUser(Long idUser);
}
