package com.website.nitadmin.service;

import com.website.nitadmin.model.Report;

import java.util.List;

public interface ReportService {

    int getNewReportInMonth();

    int getOldReportPreviousInMonth();

    List<Report> findAll();

    List<Report> findUnconfirmedReports();

    void confirmReportAndDeleteNews(Integer reportId);

    void unConfirmReport(Integer reportId);
}
