package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.enums.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserDto {
    @NotBlank(message = "Username must not be blank.")
    @Size(min = 3, max = 25, message = "Username must be between 3 and 25 characters.")
    private String username;
    
    @NotBlank(message = "Password must not be blank.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @Email(message = "Email address must be valid.")
    @NotNull(message = "Email must not be null.")
    @Size(max = 50, message = "Email must not exceed 50 characters.")
    private String email;
    
    @NotNull(message = "RoleName must not be null.")
    private RoleName roleName;

    public CreateUserDto() {
        this.roleName = RoleName.USER;
    }

    public CreateUserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleName = RoleName.USER;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public RoleName getRoleName() {
        return roleName;
    }
}
