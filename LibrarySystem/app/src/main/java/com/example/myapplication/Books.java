package com.example.myapplication;

public class Books {

    String author;
    String price;
    String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Books(String author, String price, String title) {
        this.author = author;
        this.price = price;
        this.title = title;
    }
}
