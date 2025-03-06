package com.example.cmsspringboot.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import com.example.cmsspringboot.model.Article;

@Mapper
public interface ArticleMapper {

    @Select("SELECT * FROM articles LIMIT #{limit} OFFSET #{offset}")
    List<Article> selectAll(int limit, int offset);

    @Select("SELECT COUNT(*) FROM articles")
    int countArticles();

    @Select("SELECT * FROM articles WHERE id = #{id}")
    Article findById(Long id);

    @Insert("INSERT INTO articles(title, content, author) VALUES(#{title}, #{content}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Article article);

    @Update("UPDATE articles SET title = #{title}, content = #{content}, author = #{author} WHERE id = #{id}")
    void update(Article article, Long id);

    @Delete("DELETE FROM articles WHERE id = #{id}")
    void delete(Long id);
}       
