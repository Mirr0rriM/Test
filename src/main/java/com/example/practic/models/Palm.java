package com.example.practic.models;

import javax.persistence.*;

@Entity
@Table(name = "palm")
public class Palm extends Classification{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public int getCountOfFruits() {
        return countOfFruits;
    }

    public void setCountOfFruits(int countOfFruits) {
        this.countOfFruits = countOfFruits;
    }

    @Column
    private int countOfFruits;
}
