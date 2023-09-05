package io.github.mateuscavedini.moviesapi.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import io.github.mateuscavedini.moviesapi.model.List;
import io.github.mateuscavedini.moviesapi.model.Role;
import io.github.mateuscavedini.moviesapi.model.User;
import io.github.mateuscavedini.moviesapi.model.dto.CreateUserDto;

public final class UserMockDataUtil {
    private UserMockDataUtil() {};

    public static CreateUserDto mockCreateUserDtoA() {
        return new CreateUserDto("MockUserA", "userA123", "usera@email.com");
    }

    public static CreateUserDto mockCreateUserDtoB() {
        return new CreateUserDto("MockUserB", "userB123", "userb@email.com");
    }

    public static User mockUser(CreateUserDto userDto, Set<Role> roles) {
        Set<List> freshListSet = new HashSet<>();
        return new User(userDto, freshListSet, roles);
    }

    public static Set<User> mockUserSet(Set<Role> roles) {
        return new HashSet<>(Arrays.asList(mockUser(mockCreateUserDtoA(), roles), mockUser(mockCreateUserDtoB(), roles)));
    }

    public static Set<User> mockUserSet(Set<Role> rolesA, Set<Role> rolesB) {
        return new HashSet<>(Arrays.asList(mockUser(mockCreateUserDtoA(), rolesA), mockUser(mockCreateUserDtoB(), rolesB)));
    }
}
