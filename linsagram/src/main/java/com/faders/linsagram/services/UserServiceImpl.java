package com.faders.linsagram.services;

import com.faders.linsagram.models.User;
import com.faders.linsagram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        if (!ObjectUtils.isEmpty(user.getId()) && userRepository.existsById(user.getId())) {
            throw new IllegalStateException("El id del usuario ya existe");
        }else if (!ObjectUtils.isEmpty(user.getUserName()) && userRepository.existsByUserName(user.getUserName())) {
            throw new IllegalStateException("El nombre de usuario ya existe");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllSortByAge() {
        return null;
    }
}
