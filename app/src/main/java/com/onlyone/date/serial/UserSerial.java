package com.onlyone.date.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Android两种序列化方式详解（一）：Serializable
 * 原文链接：https://blog.csdn.net/u011172283/article/details/84724145
 */
public class UserSerial implements Serializable {

    private String name;
    private String nameNew;
    private transient String age;

    public String getName() {
        return name;
    }

    public UserSerial setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * serialVersionUID这个字段的值又是干什么用的呢？
     * <p>
     * 其实 serialVersionUID 这个字段，是序列化和反序列化过程中，用来校验类是否发生了变动的依据，
     * 序列化的时候系统会把当前类的 serialVersionUID 字段写入序列化的文件中，
     * 当反序列化的时候，系统会去检测文件中的 serialVersionUID，看它是否和当前类的 serialVersionUID 一致，
     * 如果一致就说明序列化时类的版本和当前类的版本是相同的，这个时候可以成功反序列化，
     * 否则就说明当前类和序列化时的类相比发生了某些变换，比如增删了某些成员变量等，
     * 这个时候是无法正常的反序列化的，并且会报 InvalidClassException。
     */
    private static final long serialVersionUID = -6548407920722006846L;

    /**
     * 自定义序列化过程
     */
    private void writeObject(ObjectOutputStream out) {
        ObjectOutputStream.PutField putFields = null;
        try {
            putFields = out.putFields();
            putFields.put("name", name);
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 自定义反序列化过程
     */
    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField readFields = in.readFields();
            name = (String) readFields.get("name", "");
            // ...
            //通过反序列化，使name赋值给nameNew
            nameNew = (String) readFields.get("name", "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
