package com.website.nitadmin.repository;

import com.website.nitadmin.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Integer> {


    @Query("SELECT COUNT(r) FROM Report r WHERE r.createDate > :date")
    int countNewReportCountInMonth(@Param("date") Date date);


    @Query("SELECT COUNT(r) FROM Report r WHERE r.createDate < :date")
    int countOldReportCountInPreviousMonth(@Param("date") Date date);

    @Query("SELECT r FROM Report r WHERE r.confirm = false")
    List<Report> findUnconfirmedReports();

}
