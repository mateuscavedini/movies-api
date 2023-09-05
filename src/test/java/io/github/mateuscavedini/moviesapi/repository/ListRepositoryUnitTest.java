package io.github.mateuscavedini.moviesapi.repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.github.mateuscavedini.moviesapi.enums.ListTypeName;
import io.github.mateuscavedini.moviesapi.enums.RoleName;
import io.github.mateuscavedini.moviesapi.model.List;
import io.github.mateuscavedini.moviesapi.model.ListType;
import io.github.mateuscavedini.moviesapi.model.Role;
import io.github.mateuscavedini.moviesapi.model.User;
import io.github.mateuscavedini.moviesapi.util.UserMockDataUtil;

@DataJpaTest
public class ListRepositoryUnitTest {
    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ListTypeRepository listTypeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private final Role userRole = new Role(RoleName.USER);
    private final Set<Role> roles = new HashSet<>(Arrays.asList(userRole));
    private final User user = UserMockDataUtil.mockUser(UserMockDataUtil.mockCreateUserDtoA(), roles);
    private final ListType favoritesListType = new ListType(ListTypeName.FAVORITES);
    private final ListType watchedListType = new ListType(ListTypeName.WATCHED);
    private final ListType toWatchListType = new ListType(ListTypeName.TO_WATCH);
    private final Set<ListType> listTypeSet = new HashSet<>(Arrays.asList(favoritesListType, watchedListType, toWatchListType));
    private final List expectedList = new List(favoritesListType, user);
    private final Set<List> expectedListSet = listTypeSet.stream().map(listType -> new List(listType, user)).collect(Collectors.toSet());

    @AfterEach
    public void tearDown() {
        listTypeRepository.deleteAll();
        roleRepository.deleteAll();
        userRepository.deleteAll();
        listRepository.deleteAll();
    }

    @Test
    public void givenPersistedLists_whenFindingAllWithMovies_thenReturnSetWithLists() {
        listTypeSet.forEach(listType -> listTypeRepository.save(listType));
        roleRepository.save(userRole);
        userRepository.save(user);
        user.setLists(expectedListSet);

        Set<List> actualListSet = listRepository.findAllWithMovies();

        Assertions.assertThatCollection(actualListSet).isEqualTo(expectedListSet);
    }

    @Test
    public void givenUnpersistedLists_whenFindingAllWithMovies_thenReturnEmptySet() {
        Set<List> actualListSet = listRepository.findAllWithMovies();

        Assertions.assertThat(actualListSet).isEmpty();
    }

    @Test
    public void givenPersistedList_whenFindingByIdWithMovies_thenOptionalHasList() {
        listTypeRepository.save(favoritesListType);
        roleRepository.save(userRole);
        userRepository.save(user);
        listRepository.save(expectedList);
        user.getLists().add(expectedList);

        Optional<List> actualOptional = listRepository.findByIdWithMovies(expectedList.getId());

        Assertions.assertThat(actualOptional).hasValue(expectedList);
    }

    @Test
    public void givenUnpersistedList_whenFindingByIdWithMovies_thenOptionalIsEmpty() {
        Optional<List> actualOptional = listRepository.findByIdWithMovies(expectedList.getId());

        Assertions.assertThat(actualOptional).isEmpty();
    }

    @Test
    public void givenPersistedLists_whenFindingAllByUserIdWithMovies_thenReturnSetWithLists() {
        listTypeSet.forEach(listType -> listTypeRepository.save(listType));
        roleRepository.save(userRole);
        userRepository.save(user);
        user.setLists(expectedListSet);

        Set<List> actualListSet = listRepository.findAllByUserIdWithMovies(user.getId());

        Assertions.assertThat(actualListSet).isEqualTo(expectedListSet);
    }

    @Test
    public void givenUnpersistedLists_whenFindingAllByUserIdWithMovies_thenReturnEmptySet() {
        Set<List> actualListSet = listRepository.findAllByUserIdWithMovies(user.getId());

        Assertions.assertThat(actualListSet).isEmpty();
    }
}
