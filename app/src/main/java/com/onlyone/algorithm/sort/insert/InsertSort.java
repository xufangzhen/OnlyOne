package com.onlyone.algorithm.sort.insert;


//直接插入，从第二个开始依次插入前面的有序队列，使得队列依然有序
// 二分插入，用二分法查找插入的位置，将元素插入到指定位置

public class InsertSort {

    public static void sort(int[] dates) {
        int length = dates.length;
        for (int i = 1; i < length; i++) {
            int temp = dates[i];
            int index = i;
            for (int j = 0; j < i; j++) {
                if (temp < dates[i - j - 1]) {
                    dates[i - j] = dates[i - j - 1];
                    index = i - j - 1;
                } else {
                    break;
                }
            }
            dates[index] = temp;
        }
    }
}
