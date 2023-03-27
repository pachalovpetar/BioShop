package com.myproject.bioshop.web;

import com.myproject.bioshop.model.AppUserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Principal principal) {
        if(principal != null) {
            String name = principal.getName();
            System.out.println(name);
            return "redirect:/home";

        }

        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal AppUserDetails appUserDetails, Principal principal, Model model) {
        if(appUserDetails != null) {
            model.addAttribute("fullName", appUserDetails.getFullName());
        }

        String name = principal.getName();
        System.out.println(name);

        return "home";
    }


}
