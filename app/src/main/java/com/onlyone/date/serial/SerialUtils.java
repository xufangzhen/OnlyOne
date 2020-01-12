package com.onlyone.date.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialUtils {

    //https://blog.csdn.net/u011172283/article/details/84724145

    public static void serial(UserSerial user) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("temp.txt"));
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public UserSerial deserial() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("temp.txt"));
            return (UserSerial) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new UserSerial();
    }
}
