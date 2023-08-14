package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.mateuscavedini.moviesapi.model.List;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {
    @Query("SELECT l FROM List l LEFT JOIN FETCH l.movies")
    Set<List> findAllWithMovies();
    
    @Query("SELECT l FROM List l LEFT JOIN FETCH l.movies WHERE l.id=(:id)")
    Optional<List> findByIdWithMovies(Long id);

    @Query("SELECT l FROM List l LEFT JOIN FETCH l.movies WHERE l.user.id=(:userId)")
    Optional<List> findAllByUserIdWithMovies(Long userId);
}
