package com.example.msgphone.presenter;

import androidx.fragment.app.Fragment;

import com.example.msgphone.bean.NewsItemInfo;
import com.example.msgphone.dao.BookInfoDao;
import com.example.msgphone.portal.index.HomeFragment;
import com.example.msgphone.utils.NewsFragmentPresenter;

import java.util.List;


public class NewsFragmentPresenterImpl implements NewsFragmentPresenter {

    private HomeFragment fragment;

    public NewsFragmentPresenterImpl(Fragment fragment) {
        this.fragment = (HomeFragment) fragment;
    }

    @Override
    public void switchType() {
        BookInfoDao bookDao = new BookInfoDao();
        List<NewsItemInfo> bookList = null;

        bookList = bookDao.getBookInfoByType("0",fragment.getActivity());

        fragment.updateBookListView(bookList);
    }
}
