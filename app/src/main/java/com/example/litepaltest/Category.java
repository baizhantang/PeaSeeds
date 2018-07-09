package com.example.litepaltest;

import org.litepal.crud.DataSupport;

/**
 * Created by jethro on 2017/1/3.
 */

public class Category extends DataSupport{
    private int id;
    private String categoryName; //书的类型名称
    private int categoryCode; //类型对应的编码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}
