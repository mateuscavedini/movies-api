package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.github.mateuscavedini.moviesapi.model.Movie;
import io.github.mateuscavedini.moviesapi.util.ClientMockDataUtil;

@DataJpaTest
public class MovieRepositoryUnitTest {
    @Autowired
    private MovieRepository movieRepository;

    @AfterEach
    public void tearDown() {
        movieRepository.deleteAll();
    }
    
    @Test
    public void givenPersistedMovie_whenFindingByImdbId_thenOptionalHasMovie() {
        Movie expectedMovie = movieRepository.save(new Movie(ClientMockDataUtil.mockClientMovieResponseDtoA()));

        Optional<Movie> actualOptional = movieRepository.findByImdbId(expectedMovie.getImdbId());

        Assertions.assertThat(actualOptional).hasValue(expectedMovie);
    }

    @Test
    public void givenUnpersistedMovie_whenFindingByImdbId_thenOptionalIsEmpty() {
        Movie unpersistedMovie = new Movie(ClientMockDataUtil.mockClientMovieResponseDtoA());

        Optional<Movie> actualOptional = movieRepository.findByImdbId(unpersistedMovie.getImdbId());

        Assertions.assertThat(actualOptional).isEmpty();
    }
}
