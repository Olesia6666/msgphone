package com.example.msgphone.dao;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import com.example.msgphone.bean.NewsItemInfo;
import com.netease.yunxin.kit.alog.ALog;

import java.util.ArrayList;
import java.util.List;

public class BookInfoDao {
    /**根据id获取book**/
    public NewsItemInfo getBookInfo(String id, Activity activity){
        SQLiteDatabase db = DataBaseHelper.getDataBaseHelper(activity).getReadableDatabase();
        String[] params = new String[]{id};
        NewsItemInfo bookInfo = null;

        try {
            Cursor cursor = db.query(
                    DataBaseHelper.BOOK_ITEM_INFO_TABLE,
                    new String[]{"*"},
                    "bookId=?",
                    params,
                    "",
                    "",
                    "");
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String bookId = cursor.getString(cursor.getColumnIndex("bookId"));
                @SuppressLint("Range")String bookName = cursor.getString(cursor.getColumnIndex("bookName"));
                @SuppressLint("Range")String bookAuthor = cursor.getString(cursor.getColumnIndex("bookAuthor"));
                @SuppressLint("Range")String introduction = cursor.getString(cursor.getColumnIndex("introduction"));
                @SuppressLint("Range")String iconPath = cursor.getString(cursor.getColumnIndex("iconPath"));

                bookInfo = new NewsItemInfo();

                bookInfo.setBookName(bookName);
                bookInfo.setBookAuthor(bookAuthor);
                bookInfo.setBookId(bookId);
                bookInfo.setIntroduction(introduction);
                bookInfo.setIconPath(iconPath);

            }
        }catch (SQLException e){
            ALog.e("数据库数据读取错误:", e.getMessage());
        }

        return bookInfo;

    }

    /**根据type获取bookList**/
    public List<NewsItemInfo> getBookInfoByType(String type, Activity activity){
        SQLiteDatabase db = DataBaseHelper.getDataBaseHelper(activity).getReadableDatabase();
        List<NewsItemInfo> bookInfoList = null;

        try {
            bookInfoList = new ArrayList<NewsItemInfo>();
            Cursor cursor = db.query(
                    DataBaseHelper.BOOK_ITEM_INFO_TABLE,
                    new String[]{"*"},
                    null,
                    null,
                    "",
                    "",
                    "");
            while (cursor.moveToNext()) {
                @SuppressLint("Range")String bookId = cursor.getString(cursor.getColumnIndex("bookId"));
                @SuppressLint("Range")String bookName = cursor.getString(cursor.getColumnIndex("bookName"));
                @SuppressLint("Range")String bookAuthor = cursor.getString(cursor.getColumnIndex("bookAuthor"));
                @SuppressLint("Range")String introduction = cursor.getString(cursor.getColumnIndex("introduction"));
                @SuppressLint("Range")String iconPath = cursor.getString(cursor.getColumnIndex("iconPath"));

               NewsItemInfo bookInfo = new NewsItemInfo();

                bookInfo.setBookName(bookName);
                bookInfo.setBookAuthor(bookAuthor);
                bookInfo.setBookId(bookId);
                bookInfo.setIntroduction(introduction);
                bookInfo.setIconPath(iconPath);

                bookInfoList.add(bookInfo);

            }
        }catch (SQLException e){
            ALog.e("数据库数据读取错误:", e.getMessage());
        }

        return bookInfoList;

    }




}
