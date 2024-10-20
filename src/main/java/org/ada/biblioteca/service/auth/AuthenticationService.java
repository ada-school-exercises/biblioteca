package org.ada.biblioteca.service.auth;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.postgres.RolePostgres;
import org.ada.biblioteca.bo.postgres.UserPostgres;
import org.ada.biblioteca.dto.user.UserRequest;
import org.ada.biblioteca.dto.user.UserRequestLogin;
import org.ada.biblioteca.repository.RoleRepository;
import org.ada.biblioteca.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;


    public UserPostgres signup(UserRequest userRequest) {
        UserPostgres user = new UserPostgres();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setDateCreation(LocalDateTime.now());
        user.setDateUpdate(LocalDateTime.now());
        RolePostgres role = roleRepository.findRoleById(1L)
                .orElseThrow(() -> new EntityNotFoundException("error creating user, could not assign a role"));
        user.getRoles().add(role);
        return userRepository.createUser(user);
    }

    public UserPostgres login(UserRequestLogin userRequestLogin) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequestLogin.getUsername(),
                        userRequestLogin.getPassword()
                )
        );

        return userRepository.findUserByUsername(userRequestLogin.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("error authenticating user, could not find user"));
    }

    public List<String> getRolesName (UserPostgres user) {
        return user.getRoles().stream()
                .map(RolePostgres::getRole)
                .collect(Collectors.toList());
    }
}