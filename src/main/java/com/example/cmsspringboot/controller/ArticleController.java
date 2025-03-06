
package com.example.cmsspringboot.controller;

import com.example.cmsspringboot.dto.ArticleRequest;
import com.example.cmsspringboot.model.Article;
import com.example.cmsspringboot.service.ArticleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public Map<String, Object> getArticles(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        Map<String, Object> response = new HashMap<>();
        try {
            List<Article> articles = articleService.getArticles(page, size);
            int total = articleService.getTotalArticles();

            response.put("status", HttpStatus.ACCEPTED);
            response.put("message", "Articles data retrieved successfully");
            response.put("data", articles);
            response.put("total", total);
            response.put("page", page);
            response.put("size", size);

        } catch (Exception e) {
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("message", "Error: " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getArticleById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Article article = articleService.findArticleById(id);
            if (article != null) {
                response.put("status", 200);
                response.put("message", "Article found successfully");
                response.put("data", article);
            } else {
                response.put("status", 404);
                response.put("message", "Article not found");
            }
        } catch (Exception e) {
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("message", "Error: " + e.getMessage());
        }
        return response;
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ArticleRequest request) {
        
        try{
            Article article = new Article();
            article.setTitle(request.getTitle());
            article.setContent(request.getContent());
            article.setAuthor(request.getAuthor());
            
            articleService.saveArticle(article);
            return ResponseEntity.ok("Article successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ArticleRequest request, @PathVariable Long id) {
        
        try{
            Article article = new Article();
            article.setTitle(request.getTitle());
            article.setContent(request.getContent());
            article.setAuthor(request.getAuthor());
            
            articleService.updateArticle(article, id);
            return ResponseEntity.ok("Article successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }

    
}