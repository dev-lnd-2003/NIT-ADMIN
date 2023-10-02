package com.website.nitadmin.service;

import com.website.nitadmin.model.News;

import java.util.List;

public interface NewsService {

    public News save(News news);

    public News update(News news);

    public void delete(Integer id);

    List<News> findAllOrderByLikesDesc();
}
