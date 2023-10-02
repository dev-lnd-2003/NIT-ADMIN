package com.website.nitadmin.controller;

import com.website.nitadmin.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class StatisticController {

    @Autowired
    StatisticsService statisticsService;

   @GetMapping("admin/statistic")
   public String index(Model model){
       model.addAttribute("quantityNewCommentInMonth",statisticsService.getNewCommentCountInMonth());
       model.addAttribute("quantityNewUserInMonth",statisticsService.getNewUsersCountInMonth());
       model.addAttribute("quantityNewsInMonth",statisticsService.getNewNewsCountInMonth());
       model.addAttribute("quantityReportInMonth",statisticsService.getNewReportCountInMonth());
       model.addAttribute("monthDate",new Date().getMonth()+1);
       model.addAttribute("user",statisticsService.findAllUserInMonth());
       return "statistic";
   }

}
