package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsersModel;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public ArrayList<UsersModel> findAll() {
        return (ArrayList<UsersModel>) usersRepository.findAll();
    }

    public UsersModel save(UsersModel usersModel) {
        return usersRepository.save(usersModel);
    }

    public ArrayList<UsersModel> findByType(Optional<Integer> type) {
        return (ArrayList<UsersModel>) usersRepository.findByType(type);
    }

    public ArrayList<UsersModel> findByName(String name) {
        return (ArrayList<UsersModel>) usersRepository.findByName(name);
    }
}
