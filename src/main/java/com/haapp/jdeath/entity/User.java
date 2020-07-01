package com.haapp.jdeath.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer id;
    private String name;
    private String sureName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Account> accounts = new ArrayList<>();
}
