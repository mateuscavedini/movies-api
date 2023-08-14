package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.mateuscavedini.moviesapi.enums.ListTypeName;
import io.github.mateuscavedini.moviesapi.model.ListType;

@Repository
public interface ListTypeRepository extends JpaRepository<ListType, Long> {
    @Query("SELECT lt FROM ListType lt WHERE lt.listTypeName=(:listTypeName)")
    Optional<ListType> findByListTypeName(ListTypeName listTypeName);
}
