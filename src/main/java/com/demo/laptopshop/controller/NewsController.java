package com.demo.laptopshop.controller;


import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.News;
import com.demo.laptopshop.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsRepo newsRepo;

    @GetMapping("/")
    private List<News> getAllNews()  {
        return newsRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNews(@PathVariable Long id)    {
        News News = newsRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("News not exist " + id));
        return ResponseEntity.ok(News);
    }

    @PostMapping("/")
    public News PostNews(@RequestBody News News) {
        return newsRepo.save(News);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> PutNews(@RequestBody News News, @PathVariable Long id)  {
        News newNews = newsRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("News not exist " + id));
        newNews.setTitle(News.getTitle());
        newNews.setContent(News.getContent());
        newNews.setCate_id(News.getCate_id());
        newNews.setUpdate_at(News.getUpdate_at());
        News updateNews = newsRepo.save(newNews);
        return ResponseEntity.ok(updateNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNews(@PathVariable Long id)    {
        News News = newsRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("News not exist " + id));
        newsRepo.delete(News);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
