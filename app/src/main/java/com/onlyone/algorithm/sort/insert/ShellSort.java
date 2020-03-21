package com.onlyone.algorithm.sort.insert;


//希尔排序
//缩小增量和

public class ShellSort {

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
