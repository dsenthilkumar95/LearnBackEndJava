package com.improve.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/userwithcompositekey")
public class UserWithCompositeKeyController {
    @Autowired
    private UserWithCompositeKeyService userWithCompositeKeyService;

    @GetMapping(value = "getall", produces = "application/json", consumes = "application/json")
    public List<UserWithCompositeKey> getAllUserWithCompositeKey(){
        return userWithCompositeKeyService.getAllUserWithCompositeKey();
    }

    @PostMapping(value = "create", produces = "application/json", consumes = "application/json")
    public UserWithCompositeKeyDTO createUserWithCompositeKey(@RequestBody UserWithCompositeKeyDTO userWithCompositeKeyDto){
        return userWithCompositeKeyService.createNewUser(userWithCompositeKeyDto);
    }
}
