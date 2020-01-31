package com.ryszard.controller;

import com.ryszard.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("employee")Employee theEmployee, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()){
            return "employee-form";
        } else {
            return "employee-confirmation";
        }
    }
}
