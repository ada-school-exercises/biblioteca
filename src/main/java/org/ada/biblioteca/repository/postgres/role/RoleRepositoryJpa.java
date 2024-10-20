package org.ada.biblioteca.repository.postgres.role;

import org.ada.biblioteca.bo.postgres.RolePostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositoryJpa extends JpaRepository<RolePostgres, Long> {
}
