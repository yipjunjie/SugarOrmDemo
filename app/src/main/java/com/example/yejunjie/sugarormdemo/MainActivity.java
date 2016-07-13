package com.example.yejunjie.sugarormdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Book book = new Book();
        book.setEdition("d");
        book.setPrice("2");
        book.save();
        List<Book> b =Book.listAll(Book.class);
        b.toString();
    }


}
