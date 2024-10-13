package org.ada.biblioteca.repository.postgres;

import org.ada.biblioteca.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {
}
