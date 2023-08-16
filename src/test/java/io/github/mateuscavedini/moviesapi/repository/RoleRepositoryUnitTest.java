package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.github.mateuscavedini.moviesapi.enums.RoleName;
import io.github.mateuscavedini.moviesapi.model.Role;

@DataJpaTest
public class RoleRepositoryUnitTest {
    @Autowired
    private RoleRepository roleRepository;

    @ParameterizedTest
    @EnumSource(RoleName.class)
    public void givenPersistedRole_whenFindingByRoleName_thenOptionalHasRole(RoleName roleName) {
        Role expectedRole = roleRepository.save(new Role(roleName));

        Optional<Role> actualOptional = roleRepository.findByRoleName(expectedRole.getRoleName());

        Assertions.assertThat(actualOptional).hasValue(expectedRole);
    }

    @ParameterizedTest
    @EnumSource(RoleName.class)
    public void givenUnpersistedRole_whenFindingByRoleName_thenOptionalIsEmpty(RoleName roleName) {
        Role unpersistedRole = new Role(roleName);

        Optional<Role> actualOptional = roleRepository.findByRoleName(unpersistedRole.getRoleName());

        Assertions.assertThat(actualOptional).isEmpty();
    }
}
