package com.onlyone.algorithm.find;

public class FinderDemo {

    //升序数组中，返回首次出现K值的索引

    public static final int getIndexByK(int[] data, int k) {
        int low = 0;
        int high = data.length;
        return findKth(data, k, low, high);
    }


    private static final int findKth(int[] data, int k, int low, int high) {
        if (high <= low + 1) {
            if (data[low] == k) {
                return low;
            } else if (data[high] == k) {
                return high;
            } else {
                return -1;
            }
        }

        int mid = (low + high) / 2;
        if (data[mid] < k) {
            return findKth(data, k, mid + 1, high);
        } else {
            return findKth(data, k, low, mid);
        }

    }

}
