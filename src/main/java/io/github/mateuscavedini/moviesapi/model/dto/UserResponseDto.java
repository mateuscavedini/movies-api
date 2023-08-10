package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UserResponseDto {
    @NotNull(message = "Id must not be null.")
    @Positive(message = "Id must be a positive number.")
    private Long id;
    
    @NotBlank(message = "Username must not be blank.")
    @Size(min = 3, max = 25, message = "Username must be between 3 and 25 characters.")
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
