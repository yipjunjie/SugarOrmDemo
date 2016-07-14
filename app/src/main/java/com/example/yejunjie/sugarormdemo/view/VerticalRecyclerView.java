package com.example.yejunjie.sugarormdemo.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 竖方向的Recyclerview
 * Created by yjj on 16/5/4.
 */
public class VerticalRecyclerView extends RecyclerView {

    public Context mContext;

    public VerticalRecyclerView(Context context) {
        this(context, null);
    }

    public VerticalRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    private void init() { // 慎改
        //设置方向
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(linearLayoutManager);
    }
}