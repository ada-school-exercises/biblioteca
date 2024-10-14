package org.ada.biblioteca.repository;

import org.ada.biblioteca.bo.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Role create(Role role);
    List<Role> getRoles();
    Optional<Role> findRoleById(Long idRole);
    Role updateRole(Role role);
    void deleteRole(Long idRole);
}
