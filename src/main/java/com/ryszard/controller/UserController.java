package com.ryszard.controller;

import com.ryszard.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/showForm")
    public String showForm(Model userModel){
        User user = new User();

        userModel.addAttribute("user",user);

        return "user-form";
    }

    @RequestMapping("/processForm")
    public String pocessForm(@ModelAttribute("user") User user){

        System.out.println("user" + user.getUserName() + " " + user.getUserSurname());

        return "user-confirmation";
    }
}
