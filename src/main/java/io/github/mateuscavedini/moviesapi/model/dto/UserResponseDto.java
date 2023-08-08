package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.model.User;

public class UserResponseDto {
    private Long id;
    private String username;

    public UserResponseDto() {}

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
