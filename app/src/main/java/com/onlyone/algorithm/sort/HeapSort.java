package com.onlyone.algorithm.sort;

import android.util.Log;

import java.util.Arrays;

public class HeapSort {


    //降序
    public static void sort(int[] keys) {

        if (keys == null || keys.length <= 1) {
            return;
        }
        int length = keys.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            sift(keys, i, length - 1);
        }

        Log.e("first HeapSort", Arrays.toString(keys));
        for (int i = length - 1; i > 0; i--) {
            keys[0] = keys[0] ^ keys[i];
            keys[i] = keys[0] ^ keys[i];
            keys[0] = keys[0] ^ keys[i];
            sift(keys, 0, i - 1);
        }
    }

    private static void sift(int[] keys, int parent, int end) {

        int child = 0;
        int parentValue = keys[parent];

        while (parent * 2 + 1 <= end) {
            child = parent * 2 + 1;

            if (child < end && keys[child] > keys[child + 1]) {
                child++;
            }

            if (keys[child] >= parentValue) {
                break;
            }

            keys[parent] = keys[child];
            parent = child;
        }
        keys[child] = parentValue;


    }


}




