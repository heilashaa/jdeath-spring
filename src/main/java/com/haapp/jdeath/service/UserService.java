package com.haapp.jdeath.service;

import com.haapp.jdeath.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserWithMaxAccount();

    Long getSumOfAllAccounts();
}
