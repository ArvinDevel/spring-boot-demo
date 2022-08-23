package com.example.restservice.controller;

import com.example.restservice.dao.Authority;
import com.example.restservice.dao.User;
import com.example.restservice.service.UserAndAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserAndAuthorityService userAndAuthorityService;

    @RequestMapping("/saveManyToMany")
    public String save() {
        userAndAuthorityService.saveAll();
        return "权限和用户保存成功！";
    }

    @GetMapping("/findByAuthorityList_id/{id}")
    public List<User> findByAuthorityList_id(@PathVariable("id") int id) {
        return userAndAuthorityService.findByAuthorityList_id(id);
    }

    @GetMapping("/findByUsers")
    public List<Authority> getAuthBySimplePathWithRequestParam(@RequestParam("id") int id,@RequestParam("pwd") String pwd  ) {
        return userAndAuthorityService.findByUserList_id(id);
    }

}
