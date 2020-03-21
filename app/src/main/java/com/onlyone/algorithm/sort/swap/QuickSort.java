package com.onlyone.algorithm.sort.swap;

public class QuickSort {


//    时间复杂度：
//    最好情况（待排序列接近无序）时间复杂度为O(nlog2n)，
//    最坏情况（待排序列接近有序）时间复杂度为O(n2)，
//    平均时间复杂度为O(nlog2n)。

    public static final int[] NEED_QUICK_SORT = {4, 5, 6, 3, 1, 5, 7};

    public static void sort(int[] dates) {
        if (dates == null || dates.length <= 1) {
            return;
        }
        int start = 0;
        int end = dates.length - 1;
        quickSort(dates, start, end);
    }

    //    int[] keys = {81, 49, 19, 38, 97, 76, 13};
    private static void quickSort(int[] dates, int low, int high) {
        if (low >= 0 && high > low && high < dates.length) {
            int temp = dates[low];
            int start = low;
            int end = high;
            while (end > start) {
                while (end > start && dates[end] >= temp) {
                    end--;
                }
                dates[start++] = dates[end];
                while (end > start && dates[start] <= temp) {
                    start++;
                }
                dates[end--] = dates[start];
            }
            dates[start] = temp;
            quickSort(dates, low, start - 1);
            quickSort(dates, end + 1, high);
        }


    }


}
