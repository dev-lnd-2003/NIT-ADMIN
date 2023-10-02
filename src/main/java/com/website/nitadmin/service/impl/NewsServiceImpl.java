package com.website.nitadmin.service.impl;

import com.website.nitadmin.model.News;
import com.website.nitadmin.repository.NewsRepository;
import com.website.nitadmin.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News update(News news) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<News> findAllOrderByLikesDesc() {
        return newsRepository.findAllOrderByLikesDesc();
    }


}
