package com.website.nitadmin.repository;

import com.website.nitadmin.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface UserRepository extends JpaRepository<Users, Integer> {


    @Query("SELECT COUNT(u) FROM Users u WHERE u.createDate > :date")
    int countNewUsersCountInMonth(@Param("date") Date date);


    @Query("SELECT COUNT(u) FROM Users u WHERE u.createDate < :date")
    int countOldUsersCountInPreviousMonth(@Param("date") Date date);

    @Query("SELECT u FROM Users u WHERE u.createDate > :date")
    List<Users>  findAllUserInMonth(@Param("date") Date date);
}
