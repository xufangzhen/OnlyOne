package com.onlyone.copy;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFileUtils {

    public static final String TAG = "CopyFileUtils";

    public static String getDir(Context context) {

        File dir = context.getDir("libs", context.MODE_PRIVATE);
        return dir.getAbsolutePath();
    }


    /**
     * 关键步骤
     * 1. FileInputStream is = new FileInputStream(new File(origPath))  原始文件
     * 2. FileOutputStream fos = new FileOutputStream(file); 转移的位置
     * 3.
     * byte[] temp = new byte[1024];
     * while ((i = is.read(temp)) > 0) {
     * fos.write(temp, 0, i);
     * }
     *
     * @param context
     * @param origPath
     * @param destPath
     * @return
     */
    public static boolean copyLibraryFile(Context context, String origPath, String destPath) {
        boolean copyIsFinish = false;
        try {
            File dirFile = new File(destPath.substring(0, destPath.lastIndexOf("/")));
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            FileInputStream is = new FileInputStream(new File(origPath));
            File file = new File(destPath);
            if (file.exists()) {
                Log.d(TAG, "src file size=" + is.available());
                Log.d(TAG, "dest file size=" + file.length());
                if (file.length() == is.available()) {
                    return true;
                }
            }
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];
            int i = 0;
            while ((i = is.read(temp)) > 0) {
                fos.write(temp, 0, i);
            }
            fos.close();
            is.close();
            copyIsFinish = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyIsFinish;
    }
}
