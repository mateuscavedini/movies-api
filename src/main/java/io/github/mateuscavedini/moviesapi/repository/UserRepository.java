package io.github.mateuscavedini.moviesapi.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.mateuscavedini.moviesapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles")
    Set<User> findAllWithRoles();

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.id=(:id)")
    Optional<User> findByIdWithRoles(Long id);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username=(:username)")
    Optional<User> findByUsernameWithRoles(String username);
}
