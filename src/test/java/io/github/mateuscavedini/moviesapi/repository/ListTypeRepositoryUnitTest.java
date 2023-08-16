package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.github.mateuscavedini.moviesapi.enums.ListTypeName;
import io.github.mateuscavedini.moviesapi.model.ListType;

@DataJpaTest
public class ListTypeRepositoryUnitTest {
    @Autowired
    private ListTypeRepository listTypeRepository;

    @AfterEach
    public void tearDown() {
        listTypeRepository.deleteAll();
    }

    @ParameterizedTest
    @EnumSource(ListTypeName.class)
    public void givenPersitedListType_whenFindingByListTypeName_thenOptionalHasListType(ListTypeName listTypeName) {
        ListType expectedListType = listTypeRepository.save(new ListType(listTypeName));

        Optional<ListType> actualOptional = listTypeRepository.findByListTypeName(expectedListType.getListTypeName());

        Assertions.assertThat(actualOptional).hasValue(expectedListType);
    }

    @ParameterizedTest
    @EnumSource(ListTypeName.class)
    public void givenUnpersistedListType_whenFindingByListTypeName_thenOptionalIsEmpty(ListTypeName listTypeName) {
        ListType unpersistedListType = new ListType(listTypeName);

        Optional<ListType> actualOptional = listTypeRepository.findByListTypeName(unpersistedListType.getListTypeName());

        Assertions.assertThat(actualOptional).isEmpty();
    }
}
