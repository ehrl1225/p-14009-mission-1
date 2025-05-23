package com.back.step8;

public class Content {
    public static final int NULL_ID = 0;
    private int id;
    private String content;
    private String author;

    Content(){
        id = NULL_ID;
    }

    Content(String content, String author){
        this.content = content;
        this.author = author;
    }

    int getId(){
        return id;
    }

    void setID(int id){
        this.id = id;
    }

    String getContent(){
        return content;
    }

    String getAuthor(){
        return author;
    }

    void setContent(String content){
        this.content = content;
    }

    void setAuthor(String author){
        this.author = author;
    }
}
