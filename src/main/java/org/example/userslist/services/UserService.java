package org.example.userslist.services;

import org.example.userslist.model.User;
import org.example.userslist.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepo repo;

    public List<User> getUsers(){
        return repo.getUsers();
    }

    public User addUser(User user){
        return repo.addUser(user);
    }

    public User delete(User user){
        return repo.delete(user);
    }
}
