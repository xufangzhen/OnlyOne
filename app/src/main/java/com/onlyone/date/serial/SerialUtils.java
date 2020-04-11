package com.onlyone.date.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialUtils {

    //https://blog.csdn.net/u011172283/article/details/84724145

    /**
     * 通过 ObjectOutputStream.writeObject将UserSerial序列化到文件中
     * 跟踪代码：
     * 内部调用 writeObject0 、writeOrdinaryObject、writeSerialData
     * <p>
     * 1.如果实现了hasWriteObjectMethod，则通过slotDesc.invokeWriteObject(obj, this);
     * 继续调用writeObjectMethod.invoke(obj, new Object[]{ out });
     * writeObjectMethod = getPrivateMethod(cl, "writeObject", new Class<?>[]{ ObjectOutputStream.class }, Void.TYPE);
     * 就是判断被序列化的对象有没有writeObject(ObjectOutputStream out)t方法，有就用这个方法。
     * 2.否则使用defaultWriteFields，
     * Serializable的通过反射序列化
     *
     * @param user
     */
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

    /**
     * 反序列化通过 ObjectInputStream.readObject
     *
     * @return
     */
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
