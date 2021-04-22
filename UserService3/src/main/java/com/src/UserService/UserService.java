package com.src.UserService;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository userRepo;
     
    @Autowired
    private UserService userservice;
   
     
    public void updatePassword(User user,String oldPassword,String newPassword) {
    	
    	//if(user.getPassword().equals(oldPass)) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
       // userservice.save(user);
    }


	
}