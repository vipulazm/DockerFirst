package org.vipul.dockerfirst.controller;

import org.springframework.web.bind.annotation.*;
import org.vipul.dockerfirst.dto.UserDto;
import org.vipul.dockerfirst.entity.UserEntity;
import org.vipul.dockerfirst.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public void saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @GetMapping("/getAllUser")
    public List<UserEntity> getUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/deleteUser/{name}")
    public void deleteUserByName(@PathVariable(name = "name", required = true) String name){
        userService.deleteByUserName(name);
    }


}
