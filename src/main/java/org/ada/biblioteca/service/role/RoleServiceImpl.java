package org.ada.biblioteca.service.role;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.postgres.RolePostgres;
import org.ada.biblioteca.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RolePostgres createRole(RolePostgres role) {
        return roleRepository.create(role);
    }

    @Override
    public List<RolePostgres> getRoles() {
        return roleRepository.getRoles();
    }

    @Override
    public RolePostgres findRoleById(Long idRole) {
        return roleRepository.findRoleById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + idRole));
    }

    @Override
    public RolePostgres updateRole(Long idRole, RolePostgres role) {
        RolePostgres roleFound = roleRepository.findRoleById(idRole)
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
