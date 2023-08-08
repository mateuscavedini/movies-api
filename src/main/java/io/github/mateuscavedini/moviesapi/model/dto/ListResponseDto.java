package io.github.mateuscavedini.moviesapi.model.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.mateuscavedini.moviesapi.enums.ListTypeName;
import io.github.mateuscavedini.moviesapi.model.List;

public class ListResponseDto {
    private Long id;
    private ListTypeName listTypeName;
    private UserResponseDto user;
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
