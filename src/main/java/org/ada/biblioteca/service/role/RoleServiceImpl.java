package org.ada.biblioteca.service.role;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.Role;
import org.ada.biblioteca.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.create(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.getRoles();
    }

    @Override
    public Role findRoleById(Long idRole) {
        return roleRepository.findRoleById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + idRole));
    }

    @Override
    public Role updateRole(Long idRole, Role role) {
        Role roleFound = roleRepository.findRoleById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + idRole));
        roleFound.setRole(role.getRole());
        return roleRepository.updateRole(roleFound);
    }

    @Override
    public void deleteRole(Long idRole) {
        roleRepository.findRoleById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + idRole));
        roleRepository.deleteRole(idRole);
    }
}
