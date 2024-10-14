package org.ada.biblioteca.repository.postgres.role;

import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.Role;
import org.ada.biblioteca.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RoleRepositoryPostgres implements RoleRepository {

    private final RoleRepositoryJpa roleRepositoryJpa;

    @Override
    public Role create(Role role) {
        return roleRepositoryJpa.save(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepositoryJpa.findAll();
    }

    @Override
    public Optional<Role> findRoleById(Long idRole) {
        return roleRepositoryJpa.findById(idRole);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepositoryJpa.save(role);
    }

    @Override
    public void deleteRole(Long idRole) {
        roleRepositoryJpa.deleteById(idRole);
    }
}
