package com.comcast.genesys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GenesysController {

    @Autowired
    GenesysService genesysService;

    // Get all Users
    @GetMapping(path="/getUsers", produces="application/json", consumes = "application/json")
    public @ResponseBody
    List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();
        return allUsers;
    }

    @PostMapping(path="/createUser", produces="application/json", consumes = "application/json")
    public @ResponseBody User createUser(User user){
        User outUser = genesysService.creatingUser(user);
        return outUser;
    }
}