package com.haapp.jdeath.dao;

import com.haapp.jdeath.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserWithMaxAccount();

    Long getSumOfAllAccounts();
}
