package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.model.Movie;

public class MovieWithPlotResponseDto extends MovieResponseDto {
    private String plot;

    public MovieWithPlotResponseDto() {}

    public MovieWithPlotResponseDto(Movie movie) {
        super(movie);
        this.plot = movie.getPlot();
    }

    public String getPlot() {
        return plot;
    }
}
