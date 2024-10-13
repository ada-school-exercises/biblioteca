package org.ada.biblioteca.service.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.User;
import org.ada.biblioteca.dto.user.UserRequest;
import org.ada.biblioteca.dto.user.UserRequestUpdate;
import org.ada.biblioteca.dto.user.UserResponse;
import org.ada.biblioteca.repository.UserRepository;
import org.ada.biblioteca.util.caster.UserCaster;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCaster userCaster;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userCaster.userRequestToUser(userRequest);
        userRepository.createUser(user);
        return userCaster.userToUserResponse(user);
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.getUsers();
        return users.stream().map(userCaster::userToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(Long idUser) {
        User user = userRepository.findUserById(idUser)
                .orElseThrow(()-> new EntityNotFoundException("User with id " + idUser + " not found"));
        return userCaster.userToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long idUser, UserRequestUpdate userRequestUpdate) {
        User user = userRepository.findUserById(idUser)
                .orElseThrow(()-> new EntityNotFoundException("User with id " + idUser + " not found"));
        user.setName(userRequestUpdate.getName());
        user.setUsername(userRequestUpdate.getUsername());
        user.setEmail(userRequestUpdate.getEmail());
        userRepository.updateUser(user);
        return userCaster.userToUserResponse(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepository.findUserById(idUser)
                .orElseThrow(()-> new EntityNotFoundException("User with id " + idUser + " not found"));
        userRepository.deleteUser(idUser);
    }
}
