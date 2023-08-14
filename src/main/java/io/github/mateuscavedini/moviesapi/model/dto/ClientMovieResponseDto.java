package io.github.mateuscavedini.moviesapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientMovieResponseDto {
    @JsonProperty("imdbID")
    private String imdbId;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Poster")
    private String posterUrl;

    public ClientMovieResponseDto() {}

    public ClientMovieResponseDto(String imdbId, String title, String year, String plot, String posterUrl) {
        this.imdbId = imdbId;
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

    public String getYear() {
        return year;
    }

    public String getPlot() {
        return plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
