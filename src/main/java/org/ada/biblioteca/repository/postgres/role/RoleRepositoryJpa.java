package org.ada.biblioteca.repository.postgres.role;

import org.ada.biblioteca.bo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositoryJpa extends JpaRepository<Role, Long> {
}
