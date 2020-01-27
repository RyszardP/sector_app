package com.ryszard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HiController {

    @RequestMapping("/showFormPage")
    public String showFormPage() {
        return "form-page";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "hi-page";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloITVDN() {
        return "index";
    }

    @RequestMapping("/processFormVersionTwo")
    public String helloMessage(HttpServletRequest request, Model model) {
        String theName = request.getParameter("username");
        String result = "Hello!" + theName;
        model.addAttribute("HelloUserNameMesage", request);
        return "hi-page";
    }
}
