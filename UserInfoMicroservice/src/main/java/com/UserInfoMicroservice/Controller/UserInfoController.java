package com.UserInfoMicroservice.Controller;

import com.UserInfoMicroservice.DTO.UserInfoDTO;
import com.UserInfoMicroservice.Module.UserInfoModule;
import com.UserInfoMicroservice.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @PostMapping ("/createUser")
    public String createUser(@RequestBody UserInfoDTO userInfoDTO)
    {
        try{
            UserInfoModule userInfoModule = new UserInfoModule();
            userInfoModule.setUserName(userInfoDTO.getUserName());
            userInfoRepository.save(userInfoModule);
        }catch (Exception e)
        {
            return "User Not Created";
        }
        return "User Created";
    }

    //get user by Id
    @GetMapping("/getUserById/{userId}")
    public UserInfoModule getUserById(@PathVariable int userId)
    {
        return userInfoRepository.findByUserId(userId);
    }

    //get all users
    @GetMapping("/getAllUsers")
    public List<UserInfoModule> getAllUsers()
    {
        return userInfoRepository.findAll();
    }
}
