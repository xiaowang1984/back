package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    UserService userService;


    @GetMapping("/index")
    public List<User> index(){
        return userService.list();
    }
    @GetMapping("/index2")
    public String index2(){
       return  "abcde";
    }
    @GetMapping("/index3")
    public String abc(){
        return "abcd";
    }
}
