package com.project.ks8.simpleexample.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
}
