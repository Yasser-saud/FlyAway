package com.example.SpringMvc.Repo;

import com.example.SpringMvc.model.Admin;
import com.example.SpringMvc.model.Airline;

import java.util.List;

public interface AdminRepo {
    void addAdmin(Admin admin);
    Admin getByUsername(String username);
}
