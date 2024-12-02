package org.example.logic.service;

import org.example.logic.database.UserDAL;
import org.example.logic.entity.User;
import org.springframework.stereotype.Service;

@Service
public class userService {
    private UserDAL userDal;
    public userService(UserDAL userDal){
        this.userDal = userDal;
    }
    public int registerUser(User user){

        User result= new User(user.getFullName(),user.getPhone(),user.getPassword());
        return userDal.registerUser(result);
    }
    public String[] loginUser(String phoneNumber,String password){
        return userDal.loginUser(phoneNumber,password);
    }
}
