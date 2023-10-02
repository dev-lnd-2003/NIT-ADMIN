package com.website.nitadmin.controller;

import com.website.nitadmin.model.Users;
import com.website.nitadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/admin/manage-user")
    public String index(Model model){
        model.addAttribute("countUser",userService.countUser());
        model.addAttribute("getUserPreviousInMonth",userService.getOldUserCountInPreviousMonth());
        model.addAttribute("getNewUserInMonth",userService.getNewUserCountInMonth());
        model.addAttribute("user",userService.findAll());

        return "manage_user";
    }

//    @PutMapping("/admin/manage-user/update/{id}")
//    public Users update(@PathVariable("id") String id,Users users){
//        U
//    }
}
