package com.exam.server.controller;

import com.exam.server.entity.UserLoginInfo;
import com.exam.server.service.UserLoginService;

import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class LoginController {


    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @MutationMapping
    public Boolean addUser(@Argument UserLoginInfo  userLoginInfo) {
       try{
           userLoginService.save(userLoginInfo);
           return true;
        }catch (Exception e){
           return false;
       }
   }
}
