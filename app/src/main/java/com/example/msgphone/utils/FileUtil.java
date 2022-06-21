package com.example.msgphone.utils;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import com.netease.yunxin.kit.alog.ALog;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
    private static final File parentPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    private static String storagePath = "";
    private static String DST_FOLDER_NAME = "JCamera";

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static String initPath() {
        if (storagePath.equals("")) {
            storagePath = LoadLocalPic.PIC_DIR;
            File f = new File(storagePath);
            if (!f.exists()) {
                f.mkdir();
            }
        }
        return storagePath;
    }

    public static String saveBitmap(String dir, Bitmap b) {
        DST_FOLDER_NAME = dir;
        String path = initPath();
        long dataTake = System.currentTimeMillis();
        String jpegName = path + File.separator + dir + ".jpg";
        try {
            FileOutputStream fout = new FileOutputStream(jpegName);
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            b.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            return jpegName;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String saveBitmapAndroidQ(Context context, String dir, Bitmap b) {
        long dataTake = System.currentTimeMillis();
        String jpegName = "IMG_" + dataTake + ".jpg";

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, jpegName);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, "DCIM/" + dir);

        Uri external;
        ContentResolver resolver = context.getContentResolver();
        String status = Environment.getExternalStorageState();
        // 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            external = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else {
            external = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        }

        Uri insertUri = resolver.insert(external, values);
        if (insertUri == null) {
            return "";
        }
        OutputStream os;
        try {
            os = resolver.openOutputStream(insertUri);
            b.compress(Bitmap.CompressFormat.JPEG, 100, os);
            if (os != null) {
                os.flush();
                os.close();
            }
            return insertUri.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String copy2DCIMAndroidQ(Context context, String path, String saveDirName) {
        String[] splits = path.split("/");
        String fileName = splits[splits.length - 1];

        ContentValues values = new ContentValues();
        values.put(MediaStore.Video.Media.DISPLAY_NAME, fileName);
        values.put(MediaStore.Video.Media.MIME_TYPE, "video/mp4");
        values.put(MediaStore.Video.Media.RELATIVE_PATH, "DCIM/" + saveDirName);

        Uri external;
        ContentResolver resolver = context.getContentResolver();
        String status = Environment.getExternalStorageState();
        // 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            external = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            external = MediaStore.Video.Media.INTERNAL_CONTENT_URI;
        }
        Uri insertUri = resolver.insert(external, values);
        if (insertUri == null) {
            return "";
        }

        try {
            InputStream is = null;
            OutputStream os = resolver.openOutputStream(insertUri);
            if (os == null) {
                return "";
            }
            int read;
            File sourceFile = new File(path);
            if (sourceFile.exists()) { // 文件存在时
                is = new FileInputStream(sourceFile); // 读入原文件
                byte[] buffer = new byte[4096];
                while ((read = is.read(buffer)) != -1) {
                    os.write(buffer, 0, read);
                }
            }
            if (is != null) is.close();
            os.close();
            return insertUri.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean deleteFile(String url) {
        boolean result = false;
        File file = new File(url);
        if (file.exists()) {
            result = file.delete();
        }
        return result;
    }

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    /**
     * 拷贝assets中的文件到SDCard中
     */
    public static boolean saveAssetsToSDCard(Context context, String name) {
        boolean isSave;
        String fileDir = LoadLocalPic.PIC_DIR ;
        File fileD = new File(fileDir);
        if (!fileD.exists() || !fileD.isDirectory()) {
            if (!fileD.mkdirs()) {
                // 文件夹创建失败
                ALog.i("copy file:", "saveAssetToSDCard: file make dir file");
            }
        }
        String filePath = fileDir + name;
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        File file = new File(filePath);
        //如果文件存在，则不拷贝
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            is = context.getAssets().open(name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            fos = new FileOutputStream(file);
            fos.write(buffer);
            isSave = true;
            ALog.i("copy file:", "saveAssetToSDCard: finish");
        } catch (Exception e) {
            isSave = false;
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return isSave;
    }
}
