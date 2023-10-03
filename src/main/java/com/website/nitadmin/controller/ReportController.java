package com.website.nitadmin.controller;

import com.website.nitadmin.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public String viewReport(Model model){
        model.addAttribute("report",reportService.findUnconfirmedReports());
        return "report";
    }
    @PostMapping("/reports/confirm/{reportId}")
    public String confirmReport(@PathVariable Integer reportId) {
        reportService.confirmReportAndDeleteNews(reportId);
        return "redirect:/admin/report"; // Chuyển hướng về trang danh sách báo cáo
    }
    @PostMapping("/reports/un-confirm/{reportId}")
    public String unConfirmReport(@PathVariable Integer reportId) {
        reportService.unConfirmReport(reportId);
        return "redirect:/admin/report"; // Chuyển hướng về trang danh sách báo cáo
    }
}
