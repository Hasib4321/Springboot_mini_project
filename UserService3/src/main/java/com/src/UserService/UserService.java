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
     
     
    public User getByResetPasswordToken(String token) {
        return userRepo.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User customer, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        customer.setPassword(encodedPassword);
         
        customer.setResetPasswordToken(null);
        userRepo.save(customer);
    }
}