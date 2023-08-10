package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.model.Movie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MovieResponseDto {
    @NotNull(message = "Id must not be null.")
    @Positive(message = "Id must be a positive number.")
    private Long id;

    @NotBlank(message = "Title must not be blank.")
    private String title;

    @Positive(message = "Year must be a positive number.")
    private Integer year;
    
    @NotBlank(message = "PosterUrl must not be blank.")
    private String posterUrl;

    public MovieResponseDto() {}

    public MovieResponseDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.year = movie.getYear();
        this.posterUrl = movie.getPosterUrl();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
