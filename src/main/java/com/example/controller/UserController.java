package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/sda")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/main/{id}")
    public String mainPageId(@PathVariable("id") int id,
                           Model model){
        model.addAttribute("user", userDAO.getUsers().get(id));
        return "index";
    }

    @RequestMapping("/main_param")
    public String mainPageParamId(@RequestParam("id") int id, Model model){
        model.addAttribute("user", userDAO.getUserById(id));
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

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("deleteButton") int id, Model model) {
        userDAO.removeUserById(id);
        model.addAttribute("users", userDAO.getUsers());
        return "index";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("editUserId") int id, Model model) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "post";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String postAction(User user){
        System.out.println("Added User: " + user.getFirstName() + " " + user.getLastName());
        userDAO.addUser(user);
        return "index";

    }

    @PostMapping("/edited")
    public String postEdit(User user, Model model){
        System.out.println("Edited User: " + user.getFirstName() + " " + user.getLastName());
        userDAO.getUsers().put(user.getId(), user);
        return "redirect:main";
    }

}
