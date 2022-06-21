package com.example.msgphone.interfaces;

import com.example.msgphone.bean.NewsItemInfo;

import java.util.List;

public interface BaseGoodsFragment {
    /** *****此处写ui方法*
     ** 在对应fragment实现****** **/


    void showToast(String dialogText);


    void updateBookListView(List<NewsItemInfo> booksList);

}
