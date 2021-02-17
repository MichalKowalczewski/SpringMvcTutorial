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
        users.add(new User(1,"Jan", "Nowak"));
        users.add(new User(2,"Stefan", "Kowalski"));
        users.add(new User(3,"Maria", "Skłodowska"));
        users.add(new User(4,"Przykladowy", "Uzytkownik"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(int id) {return users.get(id);}

    public void removeUserById(int id) {
        users.remove(id);
    }
}
