package com.example.cmsspringboot.model;

public class Article {
    private Long id;
    private String title;
    private String content;
    private String author;  

    //constructor

    public Article() {}

    public Article(String title, String content, String author_id, String author){
            this.title = title;
            this.content = content;
            this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
