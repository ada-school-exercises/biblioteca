package org.ada.biblioteca.repository.postgres.user;

import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.postgres.UserPostgres;
import org.ada.biblioteca.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryPostgres implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public UserPostgres createUser(UserPostgres user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    public List<UserPostgres> getUsers() {
        return userRepositoryJpa.findAll();
    }

    @Override
    public Optional<UserPostgres> findUserById(Long id) {
        return userRepositoryJpa.findById(id);
    }

    @Override
    public UserPostgres updateUser(UserPostgres user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepositoryJpa.deleteById(idUser);
    }

    @Override
    public Optional<UserPostgres> findUserByEmail(String email) {
        return userRepositoryJpa.findByEmail(email);
    }

    @Override
    public Optional<UserPostgres> findUserByUsername(String username) {
        return userRepositoryJpa.findByUsername(username);
    }
}
