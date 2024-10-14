package org.ada.biblioteca.service.role;

import org.ada.biblioteca.bo.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getRoles();
    Role findRoleById(Long idRole);
    Role updateRole(Long idRole, Role role);
    void deleteRole(Long idRole);
}
