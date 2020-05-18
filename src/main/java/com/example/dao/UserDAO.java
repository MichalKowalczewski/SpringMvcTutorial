package com.example.dao;

import com.example.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private List<User> users = new ArrayList<User>();

    @PostConstruct
    public void init(){
        users.add(new User("Jan", "Nowak"));
        users.add(new User("Stefan", "Kowalski"));
        users.add(new User("Maria", "Skłodowska"));
        users.add(new User("Przykladowy", "Uzytkownik"));
    }

    public List<User> getUsers() {
        return users;
    }
}
