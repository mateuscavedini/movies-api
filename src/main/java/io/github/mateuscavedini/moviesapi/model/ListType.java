package io.github.mateuscavedini.moviesapi.model;

import io.github.mateuscavedini.moviesapi.enums.ListTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_list_type")
public class ListType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_type_id", nullable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "list_type_name", nullable = false, unique = true, length = 15)
    private ListTypeName listTypeName;

    public ListType() {}

    public ListType(ListTypeName listTypeName) {
        this.listTypeName = listTypeName;
    }

    public Long getId() {
        return id;
    }
    
    public ListTypeName getListTypeName() {
        return listTypeName;
    }
}
