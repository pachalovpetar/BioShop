package com.myproject.bioshop.web;

import com.myproject.bioshop.model.dto.UserProfileDto;
import com.myproject.bioshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ModelAndView getAllUsers(ModelAndView modelAndView) {
        List<UserProfileDto> users = this.userService
                .getAllUsers()
                .stream()
                .map(u -> this.modelMapper.map(u, UserProfileDto.class))
                .toList();

        modelAndView.addObject("users", users);
        modelAndView.setViewName("all-users");

        return modelAndView;
    }

}
