package com.example.multitasker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String identifier;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private Set<User> users;

}
