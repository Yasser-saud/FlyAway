package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.User;

public interface UserRepo {
    void addUser(User user);
    User getByUsername(String username);
    int updatePassword(int id,String password);
}
