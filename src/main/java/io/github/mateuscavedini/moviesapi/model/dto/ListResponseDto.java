package io.github.mateuscavedini.moviesapi.model.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.mateuscavedini.moviesapi.enums.ListTypeName;
import io.github.mateuscavedini.moviesapi.model.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ListResponseDto {
    @NotNull(message = "Id must not be null.")
    @Positive(message = "Id must be a positive number.")
    private Long id;

    @NotNull(message = "ListTypeName must not be null.")
    private ListTypeName listTypeName;

    @NotNull(message = "User must not be null.")
    private UserResponseDto user;
    
    @NotNull(message = "Movies must not be null.")
    private Set<MovieResponseDto> movies = new HashSet<>();

    public ListResponseDto() {}

    public ListResponseDto(List list) {
        this.id = list.getId();
        this.listTypeName = list.getListType().getListTypeName();
        this.user = new UserResponseDto(list.getUser());
        this.movies = list.getMovies().stream().map(movie -> new MovieResponseDto(movie)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public ListTypeName getListTypeName() {
        return listTypeName;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public Set<MovieResponseDto> getMovies() {
        return movies;
    }
}
