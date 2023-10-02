package com.website.nitadmin.service.impl;


import com.website.nitadmin.dto.UserDTO;
import com.website.nitadmin.model.Users;
import com.website.nitadmin.repository.UserRepository;
import com.website.nitadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Integer id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public Users update(Integer id, Users users) {
        users = getUserById(id);
        return usersRepository.save(users);
    }


    @Override
    public int countUser() {
        return usersRepository.findAll().size();
    }

    @Override
    public int getOldUserCountInPreviousMonth() {
        Date oneMonthAgo = getOneMonthAgo();
        return usersRepository.countOldUsersCountInPreviousMonth(oneMonthAgo);
    }

    @Override
    public int getNewUserCountInMonth() {
        Date oneMonthAgo = getOneMonthAgo();
        return usersRepository.countNewUsersCountInMonth(oneMonthAgo);
    }

    private Date getOneMonthAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        return calendar.getTime();
    }

}
