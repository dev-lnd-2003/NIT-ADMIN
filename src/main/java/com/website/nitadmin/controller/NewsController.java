package com.website.nitadmin.controller;

import com.website.nitadmin.model.News;
import com.website.nitadmin.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class NewsController {


    @Autowired
    NewsService newsService;
    @GetMapping("/news")
    public String viewNews(Model model){
        model.addAttribute("news",newsService.findAllOrderByLikesDesc());
        return "manage_news";
    }
    @PostMapping("/news/create")
    public String addNews(News news, @RequestParam("category") String category ){
      news.setCategory(category); // Đặt giá trị thể loại
      newsService.save(news);
      return "redirect:/admin/news";
    }

    @GetMapping("/news/edit/{id}")
    public String editNews(Model model,@PathVariable("id") News news){
        model.addAttribute("news",news);
        System.out.println(news);
        return "edit_news";
    }

    @PostMapping("/news/update/{id}")
    public String updateNews(Model model,News news){
        newsService.save(news);
        return "redirect:/admin/news";
    }
    @PostMapping("/news/delete/{id}")
    public String deleteNews(@PathVariable("id") Integer id){
        newsService.delete(id);
        return "redirect:/admin/news";

    }
}
