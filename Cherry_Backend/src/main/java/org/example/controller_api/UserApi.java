package org.example.controller_api;

import org.example.logic.database.UserDAL;
import org.example.logic.dto.LoginDTO;
import org.example.logic.entity.User;
import org.example.logic.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserDAL userDal;
    @Autowired
    public UserApi(UserDAL userDal){
        this.userDal = userDal;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public String[] registerUser(@RequestBody User user){
        userService service=new userService(userDal);
        return service.registerUser(user);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public String[] loginUser(@RequestBody LoginDTO loginDTO){
        String phoneNumber=loginDTO.getPhoneNumber();
        String password=loginDTO.getPassword();
        userService service=new userService(userDal);
        return service.loginUser(phoneNumber,password);
    }
}