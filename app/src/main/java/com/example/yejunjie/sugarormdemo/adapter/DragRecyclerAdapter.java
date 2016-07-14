package com.example.yejunjie.sugarormdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yejunjie.sugarormdemo.Book;

import com.example.yejunjie.sugarormdemo.R;
import com.example.yejunjie.sugarormdemo.view.DeleteDialog;
import com.example.yejunjie.sugarormdemo.view.RecyclerViewDragHolder;

import java.util.List;

import lib.lhh.fiv.library.FrescoImageView;


/**
 * 滑动删除
 * Created by yejunjie on 16/7/13
 */
public class DragRecyclerAdapter extends RecyclerView.Adapter {

    private static final String TAG = "DragRecyclerAdapter";
    private Context mContext;
    private List<Book> mBookList;
    public DragRecyclerAdapter(Context context,DragRectcleritemListener dragRectcleritemListener) {
        this.mContext = context;
        this.mDragRectcleritemListener = dragRectcleritemListener;
    }

    public void setData(List<Book> list) {
        mBookList = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //获取背景菜单
        View bg_menu = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_delete_bg_menu, parent, false);
        //获取item布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        //生成返回RecyclerView.ViewHolder
        return new ItemHolder(mContext, bg_menu, view, RecyclerViewDragHolder.EDGE_RIGHT).getDragViewHolder();
    }

    private ItemHolder mItemHolder;

   public class ItemHolder extends RecyclerViewDragHolder implements View.OnClickListener {

        public TextView name;
        public TextView id;
        public TextView role;
        public FrescoImageView avatar;
        public ImageView deleteItem;
        public View item;
        public int position;

        public ItemHolder(Context context, View bgView, View topView) {
            super(context, bgView, topView);
        }

        public ItemHolder(Context context, View bgView, View topView, int mTrackingEdges) {
            super(context, bgView, topView, mTrackingEdges);
        }

        @Override
        public void initView(View itemView) {
            item = itemView.findViewById(R.id.contacts_list_item);
            deleteItem = (ImageView) itemView.findViewById(R.id.contacts_delete_bg_menu_delete);
            name = (TextView) itemView.findViewById(R.id.contacts_list_item_name);
            id = (TextView) itemView.findViewById(R.id.contacts_list_item_id);
            role = (TextView) itemView.findViewById(R.id.contacts_list_item_role);
            avatar = (FrescoImageView) itemView.findViewById(R.id.contacts_list_item_avatar);
            item.setOnClickListener(this);
            mItemHolder= this;
        }

        @Override
        public void onClick(View v) {
            if (mDragRectcleritemListener != null) {
                mDragRectcleritemListener.onClick(this, v, position);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ItemHolder itemHolder = (ItemHolder) RecyclerViewDragHolder.getHolder(holder);
        itemHolder.position = position;
        Book book = mBookList.get(position);
        itemHolder.id.setText("" + book.getEdition()); // 版本
        itemHolder.name.setText(book.getName());//名字
        itemHolder.role.setText(book.getPrice());//价格

        itemHolder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDialog deleteDialog = new DeleteDialog(mContext, deleteDialogListener, position);
                deleteDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        int cout = mBookList != null ? mBookList.size() : 0;
        return cout;
    }

    /**
     * 删除对话框回调
     */
    private DeleteDialog.DeleteDialogListener deleteDialogListener = new DeleteDialog.DeleteDialogListener() {
        @Override
        public void listener(int position) {
            mBookList.get(position).delete();
            mBookList.remove(position);
            notifyDataSetChanged();
            Log.e(TAG,position +" ");

        }
    };

    private int mEmpId;

    /**
     * 对外接口
     */
    private DragRectcleritemListener mDragRectcleritemListener;

    public void setDragRectcleritemListener(DragRectcleritemListener dragRectcleritemListener) {
        this.mDragRectcleritemListener = dragRectcleritemListener;
    }

    public interface DragRectcleritemListener {
        void onClick(ItemHolder itemHolder, View v, int group);

        void update();
    }

}

