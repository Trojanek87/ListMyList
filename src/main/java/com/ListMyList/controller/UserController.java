package com.ListMyList.controller;

import com.ListMyList.logic.UserService;
import com.ListMyList.model.DTO.UserWriteModel;
import com.ListMyList.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    UserController (final UserService userService){
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<?> createUser (@RequestBody @Valid UserWriteModel toCreate){
        System.out.println("doszło");
        User result = userService.createUser(toCreate);
        logger.warn("User added");
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<?> readAllUsers(){
        logger.warn("Exposing all the users");
        return ResponseEntity.ok(userService.findAll());
    }

}
