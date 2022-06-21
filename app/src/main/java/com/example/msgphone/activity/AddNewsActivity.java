package com.example.msgphone.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.msgphone.MyApplication;
import com.example.msgphone.R;
import com.example.msgphone.dao.DataBaseHelper;
import com.example.msgphone.utils.FileUtil;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

/***
 * 新建日程页面
 */
public class AddNewsActivity extends FragmentActivity implements View.OnClickListener {
    private Context mContext;
    private EditText mEtTitle;
    private EditText mEtLocation;
    private EditText mEtRemark;
    private TextView tv_cancle, tv_save;
    private ImageView pic;//选择图片按钮
    private boolean isPic = false;
    private String picName;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_news_activity);
        getWindow().setBackgroundDrawable(null);
        picName = System.currentTimeMillis() + "";
        isPic = false;

        initView();
        initData();
        initListener();
        getEditIntentInfo();
    }

    /**
     * 获取编辑日程的Intent信息
     */
    private void getEditIntentInfo() {
        //设置光标位置在末尾
        if (!TextUtils.isEmpty(mEtTitle.getText())) {
            mEtTitle.setSelection(mEtTitle.length());
            mEtTitle.requestFocus();
        }
    }


    private void initView() {
        mContext = this;
        mEtTitle = findViewById(R.id.et_title);
        mEtLocation = findViewById(R.id.et_author);
        mEtRemark = findViewById(R.id.et_content);
        pic = findViewById(R.id.pic);
        tv_save = findViewById(R.id.tv_save);
        tv_cancle = findViewById(R.id.tv_cancle);

        tv_save.setOnClickListener(this);
        tv_cancle.setOnClickListener(this);
    }

    private void initData() {
        id = getIntent().getStringExtra("id");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancle:
                finish();
                break;
            case R.id.tv_save:
                String title = mEtTitle.getText().toString();
                String author = mEtLocation.getText().toString();
                String content = mEtRemark.getText().toString();
                if (!title.isEmpty() &&
                        !author.isEmpty() &&
                        !content.isEmpty() &&
                        isPic
                ) {
                    DataBaseHelper.getDataBaseHelper(this).insertDatas(id, title, author, content, picName + ".jpg");
                    finish();
                } else {//提示没有输入内容
                    Toast.makeText(this,"信息不能为空！",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void initListener() {
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(AddNewsActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(false, 200, 200, 1, 1);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*结果回调*/
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                isPic = true;
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                FileUtil.saveBitmap(picName, BitmapFactory.decodeFile(pictureBean.getPath()));
                if (pictureBean.isCut()) {
                    pic.setImageBitmap(BitmapFactory.decodeFile(pictureBean.getPath()));
                } else {
                    pic.setImageURI(pictureBean.getUri());
                }

                //使用 Glide 加载图片
                /*Glide.with(this)
                        .load(pictureBean.isCut() ? pictureBean.getPath() : pictureBean.getUri())
                        .apply(RequestOptions.centerCropTransform()).into(mIvImage);*/
            }
        }
    }

}
