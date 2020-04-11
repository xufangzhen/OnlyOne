package com.onlyone.algorithm.sort.merge;


//直接插入，从第二个开始依次插入前面的有序队列，使得队列依然有序
// 二分插入，用二分法查找插入的位置，将元素插入到指定位置

public class MergeSort {

    public void sort(int[] data) {
        int low = 0;
        int high = data.length - 1;
        merge(data, low, high);


    }

    public void merge(int[] data, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            //左边排好
            merge(data, low, mid);
            //右边排好
            merge(data, mid + 1, high);
            //整体排列
            mergeSort(data, low, high);
        }
    }

    public void mergeSort(int[] data, int low, int high) {

        int temp[] = new int[data.length];

        int mid = low + (high - low) / 2 + 1;
        int curIndex = low;

        int startIndex1 = low;
        int startIndex2 = mid;

        while (startIndex1 < mid && startIndex2 <= high) {
            if (data[startIndex1] < data[startIndex2]) {
                temp[curIndex++] = data[startIndex1++];
            } else {
                temp[curIndex++] = data[startIndex2++];
            }
        }

        //如果前部分还有剩余
        while (startIndex1 < startIndex2) {
            temp[curIndex++] = data[startIndex1++];
        }

        //如果后部分还有剩余
        while (startIndex2 <= high) {
            temp[curIndex++] = data[startIndex2++];
        }

        //将temp复制给data
        for (int k = low; k <= high; k++) {
            data[k] = temp[k];
        }


    }

}
