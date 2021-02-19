package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
@RequestMapping("/sda")
//Domyślnie singleton
//@SessionScope -  bean tworzony raz na sesje użytkownika (jeżeli otworzymy aplikacje np w innej przeglądarce, to zobaczymy w konsoli inicjalizacje)
@RequestScope //- przy każdym odwołaniu się do beana jest tworzony nowy bean
//@ApplicationScoped - bean tworzony raz na całe życie aplikacji - używany może być np do połączeń z bazą danych
public class UserController {

    @Autowired
    UserDAO userDAO;

    @PostConstruct
    public void init(){
        System.out.println("zainicjalizowano stronę");
    }

    //pobieramy id ze ścieżki, przesyłamy do argumentu metody za pomocą adnotacji @PathVariable
    @RequestMapping("/main/{id}")
    public String mainPageId(@PathVariable("id") int id,
                           Model model){
        //dostarczamy atrybut "users" który będzie dostępny w warstwie widoku
        model.addAttribute("user", userDAO.getUserById(id));
        return "index";
    }


    @RequestMapping("/main_param")
    public String mainPageParamId(@RequestParam("id") int id, Model model){
        model.addAttribute("user", userDAO.getUserById(id));
        return "index";
    }

    //index.html
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
    public String deleteUser(@RequestParam("deleteButton") int id, Model model){
        userDAO.removeUserById(id);
        model.addAttribute("users", userDAO.getUsers());
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String postAction(User user){
            System.out.println("Added User: " + user.getFirstName() + " " + user.getLastName());
            userDAO.addUser(user);
            return "redirect:main";

    }
}
