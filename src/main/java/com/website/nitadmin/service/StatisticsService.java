package com.website.nitadmin.service;

import com.website.nitadmin.model.Users;

import java.util.Date;
import java.util.List;

public interface StatisticsService {



    public int getNewUsersCountInMonth();

    public int getNewNewsCountInMonth();

    public int getNewCommentCountInMonth();

    public int getNewReportCountInMonth();

public List<Users> findAllUserInMonth();
}
