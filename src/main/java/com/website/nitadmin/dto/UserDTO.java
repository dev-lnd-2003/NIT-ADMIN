package com.website.nitadmin.dto;

import lombok.Data;

import javax.persistence.Column;


@Data
public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    @Column(name = "Fullname")
    private String fullName;

    private String email;

    private Boolean gender;


}
