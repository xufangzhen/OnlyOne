package com.onlyone.algorithm.search;

public class QuickSearch {

    public int searchK(int[] data, int k) {
        return quickSearch(data, k, 0, data.length - 1);
    }

    public int quickSearch(int[] data, int k, int low, int high) {
        if (low == high) {
            return data[low];
        }
        int index = partition(data, 0, data.length - 1);
        if (index > k) {
            return quickSearch(data, k, low, index - 1);
        } else if (index < k) {
            return quickSearch(data, k, index + 1, high);
        } else {
            return data[index];
        }
    }

    //无序数组中，查找第K大数据
    private int partition(int[] data, int low, int high) {
        int index = 0;

        int start = low;
        int end = high;

        int temp = data[index];

        while (start < end) {
            while (start < end && temp < data[end]) {
                end--;
            }
            data[start++] = data[end];

            while (start < end && temp > data[start]) {
                start++;
            }
            data[end--] = data[start];
        }
        data[start] = temp;
        return start;

    }


}









