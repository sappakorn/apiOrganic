package com.TestApi.testapi.controller;

import com.TestApi.testapi.services.UserProfileRepository;
import com.TestApi.testapi.tables.UserProfile;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userprofile")
@CrossOrigin("*")
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping("/login")
    public Object login(@RequestBody UserProfile user){
        APIResponse res = new APIResponse();
        UserProfile dbuser = userProfileRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(dbuser == null ) {
            res.setStatus(0);
            res.setMessage("รหัสผ่านไม่ถูกต้อง");
        }else{
            res.setStatus(1);
            res.setMessage("สำเร็จ");
        }
        return  res;

    }
    @PostMapping("/register")
    public Object register(@RequestBody UserProfile user){
        APIResponse res = new APIResponse();
        UserProfile dbuser = userProfileRepository.findByUsername(user.getUsername());
        if(dbuser == null){
            res.setStatus(1);
            userProfileRepository.save(user);
            res.setMessage("สมัครสำเร็จ");
        }else {
            res.setStatus(0);
            res.setMessage("มีผู้ใช้งานแล้ว");
        }
        return  res;

    }
}
