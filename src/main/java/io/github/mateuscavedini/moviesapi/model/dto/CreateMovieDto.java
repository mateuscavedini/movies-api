package io.github.mateuscavedini.moviesapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateMovieDto {
    @NotBlank(message = "ImdbId must not be blank.")
    @Size(min = 9, max = 15, message = "ImdbId must be between 9 and 15 characters.")
    private String imdbId;

    @NotBlank(message = "Title must not be blank.")
    private String title;

    @Positive(message = "Year must be a positive number.")
    private Integer year;

    @NotBlank(message = "Plot must not be blank.")
    private String plot;
    
    @NotBlank(message = "PosterUrl must not be blank.")
    private String posterUrl;

    public CreateMovieDto() {}

    public CreateMovieDto(String imdbID, String title, Integer year, String plot, String posterUrl) {
        this.imdbId = imdbID;
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.posterUrl = posterUrl;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getPlot() {
        return plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
