package org.ada.biblioteca.repository.postgres.user;

import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.User;
import org.ada.biblioteca.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryPostgres implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public User createUser(User user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepositoryJpa.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepositoryJpa.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepositoryJpa.deleteById(idUser);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepositoryJpa.findByEmail(email);
    }
}
