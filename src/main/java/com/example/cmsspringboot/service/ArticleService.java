package com.example.cmsspringboot.service;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.example.cmsspringboot.mapper.ArticleMapper;
import com.example.cmsspringboot.model.Article;

import java.util.List;
@Service

public class ArticleService {
    @Autowired

    private ArticleMapper articleMapper;

    public List<Article> selectAll(int page, int size){
        int offset = (page - 1) * size;
        return articleMapper.selectAll(size, offset);
    }

    public int getTotalArticles() {
        return articleMapper.countArticles();
    }

    public Article findArticleById(Long id){
        return articleMapper.findById(id);
    }

    public void saveArticle(Article article){
        articleMapper.insert(article);
    }

    public void updateArticle(Article article, Long id){
        articleMapper.update(article, id);
    }

    public void deleteArticle(Long id){
        articleMapper.delete(id);
    }

    public List<Article> getArticles(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArticles'");
    }
}
