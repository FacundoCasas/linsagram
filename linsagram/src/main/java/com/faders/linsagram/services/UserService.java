package com.faders.linsagram.services;


import com.faders.linsagram.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();
    public User create(User user);
    public List<User> findAllSortByAge();
}
