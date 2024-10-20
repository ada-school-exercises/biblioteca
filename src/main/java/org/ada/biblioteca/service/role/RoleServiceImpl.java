package org.ada.biblioteca.service.role;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.Role;
import org.ada.biblioteca.bo.postgres.RolePostgres;
import org.ada.biblioteca.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public Role createRole(Role role) {
        return roleRepository.create(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.getRoles();
    }

    @Override
    public Role findRoleById(String idRole) {
        if(profile.equals("postgres")) {
            try {
                Long id = Long.parseLong(idRole);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid idBook format for Postgres: " + idRole);
            }
        }
        return roleRepository.findRoleById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + idRole));
    }

    @Override
    public Role updateRole(String idRole, Role role) {
        if(profile.equals("postgres")) {
            try {
                Long id = Long.parseLong(idRole);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid idBook format for Postgres: " + idRole);
            }
        }
        Role roleFound = roleRepository.findRoleById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + idRole));
        roleFound.setRole(role.getRole());
        return roleRepository.updateRole(roleFound);
    }

    @Override
    public void deleteRole(String idRole) {
        if(profile.equals("postgres")) {
            try {
                Long id = Long.parseLong(idRole);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid idBook format for Postgres: " + idRole);
            }
        }
        roleRepository.findRoleById(idRole)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + idRole));
        roleRepository.deleteRole(idRole);
    }
}
