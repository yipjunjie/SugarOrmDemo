package com.example.yejunjie.sugarormdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.yejunjie.sugarormdemo.R;


/**
 * 横方向的Recyclerview
 * Created by yjj on 16/5/4.
 */
public class HorizontalRecyclerView extends RecyclerView {

    public Context mContext;

    public HorizontalRecyclerView(Context context) {
        this(context, null);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomRecyclerView);
        int spanCount = ta.getInt(R.styleable.CustomRecyclerView_spanCounts, 4); // 默认一行4列
        this.mContext = context;
        init(spanCount);
    }

    public void init(int spanCount) {
        if(spanCount <= 0){
            return;
        }
        //设置方向
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,spanCount);
//        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(gridLayoutManager);
    }

    public void setData(){}
}