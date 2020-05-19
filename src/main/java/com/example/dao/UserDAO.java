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
        users.add(new User(0,"Jan", "Nowak"));
        users.add(new User(1,"Stefan", "Kowalski"));
        users.add(new User(2,"Maria", "Skłodowska"));
        users.add(new User(3,"Przykladowy", "Uzytkownik"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id){
        return users.get(id);
    }
}
