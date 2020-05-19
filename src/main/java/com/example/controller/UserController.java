package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/main/{id}")
    public String mainPageId(@PathVariable("id") int id,
                           Model model){
        model.addAttribute("user", userDAO.getUsers().get(id));
        return "index";
    }

    @RequestMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("users", userDAO.getUsers());
        return "index";
    }

    @RequestMapping("/post")
    public String postPage(Model model){
        model.addAttribute("user", new User());
        return "post";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String postAction(User user){
            System.out.println("Added User: " + user.getFirstName() + " " + user.getLastName());
            return "index";

    }
}
