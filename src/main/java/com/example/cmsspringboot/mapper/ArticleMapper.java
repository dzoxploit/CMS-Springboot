package com.example.cmsspringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.cmsspringboot.model.Article;

@Mapper
public interface ArticleMapper {
    @Select("SELECT * FROM articles WHERE id = #{id}")
    Mapper findById(String username);

    @Insert("INSERT INTO articles(title, content, author) VALUES(#{title}, #{content}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Article article);

    @Update("UPDATE articles SET title = #{title}, content = #{content}, author = #{author} WHERE id = #{id}")
    void update(Article article);
}       
