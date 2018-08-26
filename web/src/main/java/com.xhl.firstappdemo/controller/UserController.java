package com.xhl.firstappdemo.controller;

import com.xhl.firstappdemo.domain.User;
import com.xhl.firstappdemo.repostory.UserRepostroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xhl on 2018/8/26.
 */
@RestController
public class UserController {
    private final UserRepostroy userRepostroy;
    @Autowired
    public UserController(UserRepostroy userRepostroy){
        this.userRepostroy=userRepostroy;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user=new User();
        user.setName(name);
        if(userRepostroy.save(user)){
            System.out.printf("用户对象: %s 保存成功！\n",user);
        };
        return user;
    }

}
