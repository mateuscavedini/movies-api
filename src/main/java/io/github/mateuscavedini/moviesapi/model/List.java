package io.github.mateuscavedini.moviesapi.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_list")
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id", nullable = false)
    private Long id;
    @ManyToOne(targetEntity = ListType.class)
    @JoinColumn(name = "list_type_id")
    private ListType listType;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(targetEntity = Movie.class)
    private Set<Movie> movies = new HashSet<>();

    public List() {}

    public List(ListType listType, User user) {
        this.listType = listType;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public ListType getListType() {
        return listType;
    }

    public User getUser() {
        return user;
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}
