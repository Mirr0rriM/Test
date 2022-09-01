package com.example.practic.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "classification")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Classification {
    public Long getId() {
        return id;
    }

    public Classification(Long id, String family, String genus, String order) {
        this.id = id;
        this.family = family;
        this.genus = genus;
        this.order = order;
    }

    public Classification() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String family;

    @Column
    private String genus;


    @Column
    private String order;
}
