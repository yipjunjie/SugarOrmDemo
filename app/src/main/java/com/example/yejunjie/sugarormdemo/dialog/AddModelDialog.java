package com.example.yejunjie.sugarormdemo.dialog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yejunjie.sugarormdemo.Book;
import com.example.yejunjie.sugarormdemo.R;

/**
 * 添加model  或者 update model 的界面
 * Created by yejunjie on 16/7/13.
 */
public class AddModelDialog extends DialogFragment {

    private Context mContext;
    private EditText editName;
    private EditText editPrice;
    private EditText editEdition;
    public final static int ADD_MODEL = 0;
    public final static  int UPDATE_MODEL = 1;
    private int mType = 0 ;
    private Book mBook;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container);
        mContext = getActivity().getApplicationContext();
        init(view);
        return view;
    }

    private void init(View view) {

        Button btnConfirm = (Button) view.findViewById(R.id.fragment_add_btn_confirm);
        btnConfirm.setOnClickListener(okClickListener);

        Button btnCancel = (Button) view.findViewById(R.id.fragment_add_btn_cancel);
        btnCancel.setOnClickListener(cancelClickListener);

        editName = (EditText) view.findViewById(R.id.fragment_add_edit_name);
        editPrice = (EditText) view.findViewById(R.id.fragment_add_edit_price);
        editEdition = (EditText) view.findViewById(R.id.fragment_add_edit_edition);
        if (mBook!=null){
            editName.setText(mBook.getName());
            editPrice.setText(mBook.getPrice());
            editEdition.setText(mBook.getEdition());
        }
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }


    public void show(FragmentManager manager, String tag,OnConfirmButtonClickListener onConfirmButtonClickListener,int type ,Book book) {
        this.mOnConfirmButtonClickListener = onConfirmButtonClickListener;
        this.mBook = book;
        this.mType = type;
        super.show(manager, tag);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private View.OnClickListener okClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mType == ADD_MODEL){
                if (checkData()){
                    Book book = new Book();
                    book.setName(editName.getText().toString());
                    book.setPrice(editPrice.getText().toString());
                    book.setEdition(editEdition.getText().toString());
                    mOnConfirmButtonClickListener.onConfrimSuccess(book,ADD_MODEL);
                    dismiss();
                }else{
                    Toast.makeText(mContext,"某些内容为空",Toast.LENGTH_SHORT).show();
                    return;
                }
            }else{
                if (checkData()){
                    mBook.setName(editName.getText().toString());
                    mBook.setPrice(editPrice.getText().toString());
                    mBook.setEdition(editEdition.getText().toString());
                    mOnConfirmButtonClickListener.onConfrimSuccess(mBook,UPDATE_MODEL);
                    dismiss();
                }else{
                    Toast.makeText(mContext,"某些内容为空",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
    };

    private View.OnClickListener cancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dismiss();
        }
    };


    private boolean checkData() {
        if (!editName.getText().toString().equals("")&&!editPrice.getText().toString().equals("")&&!editEdition.getText().toString().equals("")){
            return true;
        }
        return false;
    }

    public interface OnConfirmButtonClickListener{
        void onConfrimSuccess(Book book,int type);
    }

    private OnConfirmButtonClickListener mOnConfirmButtonClickListener;

    public void setOnConfirmButtonClickListener(OnConfirmButtonClickListener onConfirmButtonClickListener){
        this.mOnConfirmButtonClickListener = onConfirmButtonClickListener;
    }

}

