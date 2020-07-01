package com.haapp.jdeath.controller;

import com.haapp.jdeath.dto.UserDto;
import com.haapp.jdeath.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/user")
    public ModelAndView getAllUsers(@RequestParam(name = "param", required = false) String param){
        List<UserDto> userList= userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("userList", userList);
        if (param!= null && param.equals("richestUser")){
            modelAndView.addObject("richestUser", userService.getUserWithMaxAccount());
        }
        if (param!= null && param.equals("accountsSum")){
            modelAndView.addObject("accountsSum", userService.getSumOfAllAccounts());
        }
        return modelAndView;
    }
}
