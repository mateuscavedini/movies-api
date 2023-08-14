package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.mateuscavedini.moviesapi.enums.RoleName;
import io.github.mateuscavedini.moviesapi.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.roleName=(:roleName)")
    Optional<Role> findByRoleName(RoleName roleName);
}
