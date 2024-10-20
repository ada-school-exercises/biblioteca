package org.ada.biblioteca.repository.postgres.role;

import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.postgres.RolePostgres;
import org.ada.biblioteca.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RoleRepositoryPostgres implements RoleRepository {

    private final RoleRepositoryJpa roleRepositoryJpa;

    @Override
    public RolePostgres create(RolePostgres role) {
        return roleRepositoryJpa.save(role);
    }

    @Override
    public List<RolePostgres> getRoles() {
        return roleRepositoryJpa.findAll();
    }

    @Override
    public Optional<RolePostgres> findRoleById(Long idRole) {
        return roleRepositoryJpa.findById(idRole);
    }

    @Override
    public RolePostgres updateRole(RolePostgres role) {
        return roleRepositoryJpa.save(role);
    }

    @Override
    public void deleteRole(Long idRole) {
        roleRepositoryJpa.deleteById(idRole);
    }
}
