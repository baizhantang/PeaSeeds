package com.example.litepaltest;

import org.litepal.crud.DataSupport;

/**
 * Created by jethro on 2017/6/8.
 */

public class Book extends DataSupport{
    private int id ;
    private String name; //书名
    private double price; //价格
    private int pages; //页数
    private String author; //作者
    private String press; //出版社

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
