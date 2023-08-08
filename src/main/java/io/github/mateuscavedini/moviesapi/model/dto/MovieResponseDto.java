package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.model.Movie;

public class MovieResponseDto {
    private Long id;
    private String title;
    private Integer year;
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
