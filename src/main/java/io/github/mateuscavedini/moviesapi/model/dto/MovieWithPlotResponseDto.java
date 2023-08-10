package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.model.Movie;
import jakarta.validation.constraints.NotBlank;

public class MovieWithPlotResponseDto extends MovieResponseDto {
    @NotBlank(message = "Plot must not be blank.")
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
