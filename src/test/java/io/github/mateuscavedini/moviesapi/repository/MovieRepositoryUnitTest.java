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

    private Movie expectedMovie = new Movie(ClientMockDataUtil.mockClientMovieResponseDtoA());

    @AfterEach
    public void tearDown() {
        movieRepository.deleteAll();
    }
    
    @Test
    public void givenPersistedMovie_whenFindingByImdbId_thenOptionalHasMovie() {
        movieRepository.save(expectedMovie);

        Optional<Movie> actualOptional = movieRepository.findByImdbId(expectedMovie.getImdbId());

        Assertions.assertThat(actualOptional).hasValue(expectedMovie);
    }

    @Test
    public void givenUnpersistedMovie_whenFindingByImdbId_thenOptionalIsEmpty() {
        Optional<Movie> actualOptional = movieRepository.findByImdbId(expectedMovie.getImdbId());

        Assertions.assertThat(actualOptional).isEmpty();
    }
}
