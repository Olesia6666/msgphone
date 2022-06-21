package com.example.msgphone.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msgphone.R;
import com.example.msgphone.bean.NewsItemInfo;
import com.example.msgphone.utils.LoadLocalPic;
import com.netease.yunxin.kit.common.ui.activities.BaseActivity;


public class NewsDetailActivity extends BaseActivity {
    private TextView news_name_tv;
    private TextView news_author_tv;
    private TextView news_content_tv;
    private ImageView newsCover;
    private ImageView back_btn;
    private NewsItemInfo newsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        initListener();
    }

    private void initView() {
        news_name_tv = findViewById(R.id.tv_news_bookName);
        news_author_tv = findViewById(R.id.tv_news_author);
        news_content_tv = findViewById(R.id.tv_news_contents);
        newsCover = findViewById(R.id.iv_news_img);
        back_btn = findViewById(R.id.top_bar_back_btn_Textview);

        newsInfo = (NewsItemInfo) getIntent().getSerializableExtra("bookInfo");

        news_name_tv.setText(newsInfo.getBookName());
        news_author_tv.setText(newsInfo.getBookAuthor());
        news_content_tv.setText("        "+ newsInfo.getIntroduction());
        newsCover.setImageBitmap(LoadLocalPic.getBookCoverBitmap(newsInfo.getIconPath()));

    }


    private void initListener() {
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

