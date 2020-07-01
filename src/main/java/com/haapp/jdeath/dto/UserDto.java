package com.haapp.jdeath.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Dto {

    private Integer id;
    private String name;
    private String sureName;
    private Integer account;
}
