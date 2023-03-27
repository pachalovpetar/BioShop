package com.myproject.bioshop.web;

import com.myproject.bioshop.model.dto.UserRegisterForm;
import com.myproject.bioshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegisterForm")
    public UserRegisterForm initForm() {
        return new UserRegisterForm();
    }

    @GetMapping("/register")
    public String getRegister() {

        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(value = "userRegisterForm") UserRegisterForm userRegisterForm,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(userRegisterForm == null || bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegisterForm", userRegisterForm)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterForm", bindingResult);

            return "redirect:/register";
        }

        this.userService.registerUser(userRegisterForm);

        return "/login";

    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


}
