package com.example.yejunjie.sugarormdemo.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yejunjie.sugarormdemo.R;


/**
 * 删除对话框
 * Created by yjj on 16/4/29.
 */
public class DeleteDialog extends Dialog {

    private Button delete_ok;
    private Context mContext;
    private static int mTheme = R.style.CustomDialog;       // 默认主题,没标题
    private int mPosition;

    public DeleteDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
    }

    public DeleteDialog(Context context, DeleteDialogListener deleteDialogListener) {
        this(context, mTheme);
        setDeleteDialogListener(deleteDialogListener);
    }

    public DeleteDialog(Context context, DeleteDialogListener deleteDialogListener, int position) {
        this(context, deleteDialogListener);
        this.mPosition = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_delete);
        delete_ok = (Button) findViewById(R.id.dialog_delete_ok);
        delete_ok.setOnClickListener(listener);
    }

    /**
     * 确定按钮监听
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mDeleteDialogListener != null) {
                mDeleteDialogListener.listener(mPosition);
            }
            dismiss();
        }
    };


    /**
     * 对外接口
     */
    public DeleteDialogListener mDeleteDialogListener;

    public void setDeleteDialogListener(DeleteDialogListener deleteDialogListener) {
        this.mDeleteDialogListener = deleteDialogListener;
    }

    public interface DeleteDialogListener {
        void listener(int position);
    }

}
