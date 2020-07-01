package com.haapp.jdeath.dto;

import com.haapp.jdeath.entity.Account;
import com.haapp.jdeath.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoTransformer {

    public UserDto makeDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSureName(user.getSureName());
        userDto.setAccount(user.getAccounts().stream().mapToInt(Account::getAccount).sum());
        return userDto;
    }
}
