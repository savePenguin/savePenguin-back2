package com.cos.photogramstart.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@RestController  
public class PointUpdateController {
    @Autowired
    private UserService userService;
 
    @RequestMapping("/user/pointUpdate/{userid}") //포인트 수정     
    public void pointUpdate(@RequestBody User user) {
    	System.out.println("진입 ");
    	userService.pointUpdate(user.getUserid(), user.getPoint());
    	System.out.println(user.toString());	
    }
}
