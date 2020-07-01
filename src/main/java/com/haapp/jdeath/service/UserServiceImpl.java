package com.haapp.jdeath.service;

import com.haapp.jdeath.dao.UserDao;
import com.haapp.jdeath.dto.UserDto;
import com.haapp.jdeath.dto.UserDtoTransformer;
import com.haapp.jdeath.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserDtoTransformer userDtoTransformer;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        return users.stream().map(userDtoTransformer::makeDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserWithMaxAccount() {
        List<User> users = userDao.getAllUsers();
        return users.stream().map(userDtoTransformer::makeDto).max(Comparator.comparing(UserDto::getAccount)).orElseThrow(NoSuchElementException::new);
//        return userDtoTransformer.makeDto(userDao.getUserWithMaxAccount());
    }

    @Override
    public Long getSumOfAllAccounts() {
        return userDao.getSumOfAllAccounts();
    }
}
