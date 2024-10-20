package org.ada.biblioteca.service.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.postgres.UserPostgres;
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
    public List<UserResponse> getUsers() {
        List<UserPostgres> users = userRepository.getUsers();
        return users.stream().map(userCaster::userToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(Long idUser) {
        UserPostgres user = userRepository.findUserById(idUser)
                .orElseThrow(()-> new EntityNotFoundException("User with id " + idUser + " not found"));
        return userCaster.userToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long idUser, UserRequestUpdate userRequestUpdate) {
        UserPostgres user = userRepository.findUserById(idUser)
                .orElseThrow(()-> new EntityNotFoundException("User with id " + idUser + " not found"));
        user.setName(userRequestUpdate.getName());
        user.setUsername(userRequestUpdate.getUsername());
        user.setEmail(userRequestUpdate.getEmail());
        UserPostgres update = userRepository.updateUser(user);
        return userCaster.userToUserResponse(update);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepository.findUserById(idUser)
                .orElseThrow(()-> new EntityNotFoundException("User with id " + idUser + " not found"));
        userRepository.deleteUser(idUser);
    }
}
