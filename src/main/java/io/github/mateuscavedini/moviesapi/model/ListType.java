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
    @Column(name = "list_type_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "list_type_name")
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
