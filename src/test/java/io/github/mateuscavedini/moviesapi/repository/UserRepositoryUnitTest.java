package io.github.mateuscavedini.moviesapi.repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.github.mateuscavedini.moviesapi.enums.RoleName;
import io.github.mateuscavedini.moviesapi.model.Role;
import io.github.mateuscavedini.moviesapi.model.User;
import io.github.mateuscavedini.moviesapi.util.UserMockDataUtil;

@DataJpaTest
public class UserRepositoryUnitTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private final Role userRole = new Role(RoleName.USER);
    private final Set<Role> roles = new HashSet<>(Arrays.asList(userRole));
    private final User expectedUser = UserMockDataUtil.mockUser(UserMockDataUtil.mockCreateUserDtoA(), roles);
    private final Set<User> expectedUserSet = UserMockDataUtil.mockUserSet(roles);

    @AfterEach
    public void tearDown() {
        roleRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void givenPersistedUsers_whenFindingAllWithRoles_thenReturnSetWithUsers() {
        roleRepository.save(userRole);
        expectedUserSet.forEach(user -> userRepository.save(user));

        Set<User> actualUserSet = userRepository.findAllWithRoles();

        Assertions.assertThatCollection(actualUserSet).isEqualTo(expectedUserSet);
    }

    @Test
    public void givenUnpersistedUsers_whenFindingAllWithRoles_thenReturnEmptySet() {
        Set<User> actualUserSet = userRepository.findAllWithRoles();

        Assertions.assertThat(actualUserSet).isEmpty();
    }

    @Test
    public void givenPersistedUser_whenFindingByIdWithRoles_thenOptionalHasUser() {
        roleRepository.save(userRole);
        userRepository.save(expectedUser);

        Optional<User> actualOptional = userRepository.findByIdWithRoles(expectedUser.getId());

        Assertions.assertThat(actualOptional).hasValue(expectedUser);
    }

    @Test
    public void givenUnpersistedUser_whenFindingByIdWithRoles_thenOptionalIsEmpty() {
        Optional<User> actualOptional = userRepository.findByIdWithRoles(expectedUser.getId());

        Assertions.assertThat(actualOptional).isEmpty();
    }

    @Test
    public void givenPersistedUser_whenFindingByUsernameWithRoles_thenOptionalHasUser() {
        roleRepository.save(userRole);
        userRepository.save(expectedUser);

        Optional<User> actualOptional = userRepository.findByUsernameWithRoles(expectedUser.getUsername());

        Assertions.assertThat(actualOptional).hasValue(expectedUser);
    }

    @Test
    public void givenUnpersistedUser_whenFindingByUsernameWithRoles_thenOptionalIsEmpty() {
        Optional<User> actualOptional = userRepository.findByUsernameWithRoles(expectedUser.getUsername());

        Assertions.assertThat(actualOptional).isEmpty();
    }
}
