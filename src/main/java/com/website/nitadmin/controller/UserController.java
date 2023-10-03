package com.website.nitadmin.controller;

import com.website.nitadmin.model.Users;
import com.website.nitadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/admin/manage-user/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return "redirect:/admin/manage-user";
    }
}
