package com.onlyone.algorithm.sort.select;

public class SelectSort {

    //遍历一遍，选出最大值，与末尾进行交换，让最大值到末尾
    public static void sort(int[] dates) {
        int length = dates.length;
        int maxValueIndex = 0;
        for (int i = 0; i < length; i++) {
            maxValueIndex = 0;
            for (int j = 0; j < length - i; j++) {
                if (dates[j] > dates[maxValueIndex]) {
                    maxValueIndex = j;
                }
                if (j == length - i - 1 && j != maxValueIndex) {
                    int temp = dates[j];
                    dates[j] = dates[maxValueIndex];
                    dates[maxValueIndex] = temp;
                }
            }
        }
    }


}
