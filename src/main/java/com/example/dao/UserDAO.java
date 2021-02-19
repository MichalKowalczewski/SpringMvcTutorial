package com.example.dao;

import com.example.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDAO {

    private Map<Integer, User> users = new HashMap<>();

    @PostConstruct
    public void init(){
        users.put(1, new User(1,"Jan", "Nowak"));
        users.put(2, new User(2,"Stefan", "Kowalski"));
        users.put(3, new User(3,"Maria", "Sklodowska"));
        users.put(4, new User(4,"Przykladowy", "Uzytkownik"));
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public User getUserById(int id){
        return users.get(id);
    }
}
