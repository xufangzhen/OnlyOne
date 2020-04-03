package com.onlyone.algorithm.test;

import android.util.Log;


/*
String是不可变对象，即对象一旦生成，就不能被更改。对String对象的改变会引发新的String对象的生成。

StringBuffer:每次都对对象本身进行操作，而不是生成新的对象。所以在字符串内容不断改变的情况，建议使用StringBuffer。

String对象的字符串拼接其实是被JVM解释成了StringBuffer对象的拼接，所以这些时候String对象的速度并不会比StringBuffer慢。

StringBuild具有相同的操作。
区别在于：StringBuffer是线程安全的类。StringBuild不是线程安全的类，在单线程中性能要比StringBuffrer高。
        */
public class StringDemo {


    //创建了两个对象，一个在方法区，一个在堆中。
    String s = new String("abcdefg");


    String s1 = "ab";
    String s2 = "c";
    String s3 = "a";
    String s4 = "ab" + new String("c");
    String s5 = "a" + new String("bc");


    public void print() {
        Log.e("xfz", "s4 == s5 " + (s4 == s5));
    }

}
