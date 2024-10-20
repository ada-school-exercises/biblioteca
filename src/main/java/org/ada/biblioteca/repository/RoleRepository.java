package org.ada.biblioteca.repository;

import org.ada.biblioteca.bo.postgres.RolePostgres;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    RolePostgres create(RolePostgres role);
    List<RolePostgres> getRoles();
    Optional<RolePostgres> findRoleById(Long idRole);
    RolePostgres updateRole(RolePostgres role);
    void deleteRole(Long idRole);
}
