package io.github.mateuscavedini.moviesapi.model;

import io.github.mateuscavedini.moviesapi.model.dto.CreateMovieDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Long id;
    @Column(name = "imdb_id", nullable = false, unique = true, length = 15)
    private String imdbId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer year;
    @Column(columnDefinition = "text", nullable = false)
    private String plot;
    @Column(name = "poster_url", nullable = false)
    private String posterUrl;

    public Movie() {}

    public Movie(CreateMovieDto movieDto) {
        this.imdbId = movieDto.getImdbId();
        this.title = movieDto.getTitle();
        this.year = movieDto.getYear();
        this.plot = movieDto.getPlot();
        this.posterUrl = movieDto.getPosterUrl();
    }

    public Long getId() {
        return id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((imdbId == null) ? 0 : imdbId.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        result = prime * result + ((plot == null) ? 0 : plot.hashCode());
        result = prime * result + ((posterUrl == null) ? 0 : posterUrl.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (imdbId == null) {
            if (other.imdbId != null)
                return false;
        } else if (!imdbId.equals(other.imdbId))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        if (plot == null) {
            if (other.plot != null)
                return false;
        } else if (!plot.equals(other.plot))
            return false;
        if (posterUrl == null) {
            if (other.posterUrl != null)
                return false;
        } else if (!posterUrl.equals(other.posterUrl))
            return false;
        return true;
    }
}
