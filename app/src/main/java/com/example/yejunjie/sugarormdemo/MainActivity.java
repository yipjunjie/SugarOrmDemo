package com.example.yejunjie.sugarormdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yejunjie.sugarormdemo.adapter.DragRecyclerAdapter;
import com.example.yejunjie.sugarormdemo.view.VerticalRecyclerView;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Context mContext;
    private List<Book> mBookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        Fresco.initialize(this);
//        Book book = new Book();
//        book.setEdition("d");
//        book.setPrice("2");
//        book.save();
//        List<Book> b =Book.listAll(Book.class);
//        b.toString();
//        List<Book> b1 = Book.find(Book.class, "price = ?", "1");
//        b1.toString();
//        List<Book> b2 = Book.find(Book.class, "price = ? and edition = ?","2","1");
//        b2.toString();
//        List<Book> b3 = Book.find(Book.class, "price = ? and edition = ?","2","d");
//        b3.toString();
//        Book.deleteAll(Book.class, "price = ? and edition = ?","2","d");

        for (int i=0; i<20; i++){
            Book book = new Book();
            book.setEdition("edition"+i);
            book.setPrice("price"+i);
            book.setName("name"+i);
//            book.save();
            mBookList.add(book);
        }


        VerticalRecyclerView verticalRecyclerView = (VerticalRecyclerView) findViewById(R.id.contacts_list_group_rv);
        DragRecyclerAdapter dragRecyclerAdapter = new DragRecyclerAdapter(mContext,2,dragListener);
        dragRecyclerAdapter.setData(mBookList);
        verticalRecyclerView.setAdapter(dragRecyclerAdapter);
    }

    DragRecyclerAdapter.DragRectcleritemListener dragListener = new DragRecyclerAdapter.DragRectcleritemListener() {
        @Override
        public void onClick(DragRecyclerAdapter.ItemHolder itemHolder, View v, int group) {

        }

        @Override
        public void update() {

        }
    };
}
