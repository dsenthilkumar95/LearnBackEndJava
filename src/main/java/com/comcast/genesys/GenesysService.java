package com.comcast.genesys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenesysService {
    @Autowired
    UserRepository userRepository;

    public User creatingUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }
}