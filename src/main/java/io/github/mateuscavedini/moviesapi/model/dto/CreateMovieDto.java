package io.github.mateuscavedini.moviesapi.model.dto;

public class CreateMovieDto {
    private String imdbId;
    private String title;
    private Integer year;
    private String plot;
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
