package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.mateuscavedini.moviesapi.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.imdbId=(:imdbId)")
    Optional<Movie> findByImdbId(String imdbId);
}
