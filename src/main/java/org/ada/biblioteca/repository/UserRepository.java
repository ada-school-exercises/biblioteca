package org.ada.biblioteca.repository;

import org.ada.biblioteca.bo.postgres.UserPostgres;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    UserPostgres createUser(UserPostgres user);
    List<UserPostgres> getUsers();
    Optional<UserPostgres> findUserById(Long id);
    UserPostgres updateUser(UserPostgres user);
    void deleteUser(Long id);
    Optional<UserPostgres> findUserByEmail(String email);
    Optional<UserPostgres> findUserByUsername(String username);
}
