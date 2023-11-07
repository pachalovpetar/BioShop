package com.myproject.bioshop.web;

import com.myproject.bioshop.exceptions.NoSuchUserException;
import com.myproject.bioshop.model.entity.User;
import com.myproject.bioshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserRestController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}")
    private User getUser(@PathVariable long id) throws NoSuchUserException {
        return this.modelMapper
                .map(this.userService.getUserById(id), User.class);
    }


}
