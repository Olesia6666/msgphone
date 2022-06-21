package com.example.msgphone.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.netease.yunxin.kit.alog.ALog;

import java.io.File;
import java.io.FileInputStream;

public class LoadLocalPic {
    public static final String PIC_DIR = "/storage/emulated/0/ABC/pic/";

    public static Bitmap getBookCoverBitmap(String fileName){
        return getBitmap(PIC_DIR, fileName);
    }

    public static Bitmap getBitmap(String path, String fileName){
        File file = new File(path);
        Bitmap bitmap = null;
        try {
            if(!file.exists()){
                file.mkdir();
            }else {
                FileInputStream fs = new FileInputStream(path + fileName);

                bitmap  = BitmapFactory.decodeStream(fs);

            }
        } catch (Exception e) {
            e.printStackTrace();
            ALog.e("LoadLocalPic：", "图片读取出错");
        }finally {
            return bitmap;
        }

    }

}
