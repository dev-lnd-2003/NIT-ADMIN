package com.website.nitadmin.service.impl;

import com.website.nitadmin.model.News;
import com.website.nitadmin.model.Report;
import com.website.nitadmin.repository.NewsRepository;
import com.website.nitadmin.repository.ReportRepository;
import com.website.nitadmin.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    NewsRepository newsRepository;

    @Override
    public int getNewReportInMonth() {
        Date oneMonthAgo = getOneMonthAgo();
        return reportRepository.countNewReportCountInMonth(oneMonthAgo);
    }

    @Override
    public int getOldReportPreviousInMonth() {
        Date oneMonthAgo = getOneMonthAgo();
        return reportRepository.countOldReportCountInPreviousMonth(oneMonthAgo);
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> findUnconfirmedReports() {
        return reportRepository.findUnconfirmedReports();
    }

    @Override
    public void confirmReportAndDeleteNews(Integer reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);

        if(optionalReport.isPresent()){
            Report report = optionalReport.get();

            News news = report.getNews();

            news.setActive(false);
            report.setConfirm(true);
            newsRepository.save(news);
            reportRepository.save(report);
        }

    }

    @Override
    public void unConfirmReport(Integer reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        if(optionalReport.isPresent()){
            Report report = optionalReport.get();

            News news = report.getNews();

            news.setActive(true);

            newsRepository.save(news);
            reportRepository.delete(report);
        }
    }

    private Date getOneMonthAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }
}
