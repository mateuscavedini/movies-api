package io.github.mateuscavedini.moviesapi.model.dto;

import io.github.mateuscavedini.moviesapi.enums.RoleName;

public class CreateUserDto {
    private String username;
    private String password;
    private String email;
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
