package com.website.nitadmin.service.impl;

import com.website.nitadmin.model.Users;
import com.website.nitadmin.repository.*;
import com.website.nitadmin.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public int getNewUsersCountInMonth() {
        Date oneMonthAgo = getOneMonthAgo();

        return userRepository.countNewUsersCountInMonth(oneMonthAgo);
    }

    @Override
    public int getNewNewsCountInMonth() {
        Date oneMonthAgo = getOneMonthAgo();

        return newsRepository.countNewNewsCountInMonth(oneMonthAgo);
    }

    @Override
    public int getNewCommentCountInMonth() {
        Date oneMonthAgo = getOneMonthAgo();
        return commentsRepository.countNewCommentCountInMonth(oneMonthAgo);
    }

    @Override
    public int getNewReportCountInMonth() {
        Date oneMonthAgo = getOneMonthAgo();
        return reportRepository.countNewReportCountInMonth(oneMonthAgo);
    }

    @Override
    public List<Users> findAllUserInMonth() {
        Date oneMonthAgo = getOneMonthAgo();

        return userRepository.findAllUserInMonth(oneMonthAgo);
    }

    private Date getOneMonthAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

}
