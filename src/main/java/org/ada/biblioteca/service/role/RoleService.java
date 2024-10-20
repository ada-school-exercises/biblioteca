package org.ada.biblioteca.service.role;

import org.ada.biblioteca.bo.postgres.RolePostgres;

import java.util.List;

public interface RoleService {
    RolePostgres createRole(RolePostgres role);
    List<RolePostgres> getRoles();
    RolePostgres findRoleById(Long idRole);
    RolePostgres updateRole(Long idRole, RolePostgres role);
    void deleteRole(Long idRole);
}
