package com.website.nitadmin.repository;

import com.website.nitadmin.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface LikeRepository extends JpaRepository<Likes,Integer> {


}
