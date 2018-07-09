package com.example.litepaltest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //添加数据按钮
    public void addData(View view){
        Book book = new Book();
        book.setName("第一行代码");
        book.setAuthor("郭霖");
        book.setPages(400);
        book.setPress("Unknow");
        book.setPrice(16.9);
        book.save();
    }

    //修改数据按钮
    public void updata(View view){

        Book book = new Book();
        book.setPrice(9.9);
        book.updateAll("name =  ? and author = ?", "时间简史", "霍金");
    }

    //删除数据按钮
    public void deleteData(View view){
        DataSupport.deleteAll(Book.class,"price<?","20");
    }


    //查询数据
    public void queryData(View view) {
  //      List<Book> books = DataSupport.findAll(Book.class);
        List<Book> books = DataSupport.select("name", "author", "price")
                .where("price <  ?", "10")
                .order("price")
                .limit(10)
                .offset(10)
                .find(Book.class);

        Cursor c = DataSupport.findBySQL("select * from Book where pages > ? and price < ?", "400", "20");

        Log.d("MainActivity", "------开始查询数据------");

        for (Book book : books) {
            Log.d("MainActivity", "书名: "+book.getName());
            Log.d("MainActivity", "作者: "+book.getAuthor());
            Log.d("MainActivity", "价格: "+book.getPrice());
        }

    }
}

