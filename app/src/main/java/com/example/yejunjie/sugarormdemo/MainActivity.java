package com.example.yejunjie.sugarormdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.yejunjie.sugarormdemo.adapter.DragRecyclerAdapter;
import com.example.yejunjie.sugarormdemo.dialog.AddModelDialog;
import com.example.yejunjie.sugarormdemo.view.VerticalRecyclerView;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 * Created by yejunjie on 16/7/13.
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private Context mContext;
    private List<Book> mBookList = new ArrayList<>();
    DragRecyclerAdapter mDragRecyclerAdapter;
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
        initData();
        VerticalRecyclerView verticalRecyclerView = (VerticalRecyclerView) findViewById(R.id.contacts_list_group_rv);
        mDragRecyclerAdapter = new DragRecyclerAdapter(mContext,dragListener);
        mDragRecyclerAdapter.setData(mBookList);
        verticalRecyclerView.setAdapter(mDragRecyclerAdapter);
    }

    private void initData() {
        mBookList =Book.listAll(Book.class);
        if (mBookList==null||mBookList.size()==0){
            for (int i=0; i<3; i++){
                Book book = new Book();
                book.setEdition("edition"+i);
                book.setPrice("price"+i);
                book.setName("name"+i);
                book.save();
                mBookList.add(book);
            }
        }else{

        }
    }

    DragRecyclerAdapter.DragRectcleritemListener dragListener = new DragRecyclerAdapter.DragRectcleritemListener() {
        @Override
        public void onClick(DragRecyclerAdapter.ItemHolder itemHolder, View v, int position) {
            Log.e(TAG,position+" ");
            AddModelDialog updateModelDialog = new AddModelDialog();
            updateModelDialog.show(getFragmentManager(),null,onConfirmButtonClickListener,AddModelDialog.UPDATE_MODEL,mBookList.get(position));
            if  (itemHolder.isOpen()){
                itemHolder.close(); // 关闭
            }
        }

        @Override
        public void update() {

        }
    };

    public void QueryClick(View view) {

    }

    public void UpdateClick(View view) {

    }

    public void DeleteClick(View view) {

    }

    public void AddClick(View view) {
        AddModelDialog addModelDialog = new AddModelDialog();
        addModelDialog.show(getFragmentManager(),null,onConfirmButtonClickListener,AddModelDialog.ADD_MODEL,null);
    }

    AddModelDialog.OnConfirmButtonClickListener onConfirmButtonClickListener = new AddModelDialog.OnConfirmButtonClickListener() {
        @Override
        public void onConfrimSuccess(Book book,int type) {
            if (type == AddModelDialog.ADD_MODEL){
                book.save();
                mBookList.add(book);
                mDragRecyclerAdapter.setData(mBookList);
                mDragRecyclerAdapter.notifyDataSetChanged();
            }else{
                book.update();
                mDragRecyclerAdapter.notifyDataSetChanged();
            }

        }
    };

}
