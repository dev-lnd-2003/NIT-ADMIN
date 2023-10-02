package com.website.nitadmin.service;


import com.website.nitadmin.dto.UserDTO;
import com.website.nitadmin.model.Users;

import java.util.List;

public interface UserService {

    public List<Users> findAll();

    public Users getUserById(Integer id);

    public Users update(Integer id,Users users);

    public int countUser();

    public int getOldUserCountInPreviousMonth();

    public int getNewUserCountInMonth();

}
