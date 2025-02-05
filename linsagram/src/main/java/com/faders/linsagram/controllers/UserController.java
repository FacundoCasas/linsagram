package com.faders.linsagram.controllers;

import com.faders.linsagram.models.User;
import com.faders.linsagram.services.UserService;
import com.faders.linsagram.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<User> listaUsuarios = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User nuevoUsuario = userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //TODO:crear un metodo PUT de actualizacion de 1 usuario validar que el usario a actualizar exista, metodo del repositorio save


    //TODO:crear un metodo DELETE de eliminacion de 1 usuario validar que el usario a eliminar exista, metodo repositorio delete

}
