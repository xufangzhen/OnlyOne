package com.onlyone.algorithm.sort.select;

import android.util.Log;

import java.util.Arrays;

public class HeapSort {


    //降序
    public static void sort(int[] keys) {

        if (keys == null || keys.length <= 1) {
            return;
        }
        int length = keys.length;

        //最后一个根节点的父节点是（length / 2 - 1），一次往前遍历
        for (int i = length / 2 - 1; i >= 0; i--) {
            //构建堆
            sift(keys, i, length - 1);
        }

        Log.e("first HeapSort", Arrays.toString(keys));
        for (int i = length - 1; i > 0; i--) {
            //将第一个元素与最后一个替换，则最小值到最后一个
            keys[0] = keys[0] ^ keys[i];
            keys[i] = keys[0] ^ keys[i];
            keys[0] = keys[0] ^ keys[i];
            //重新构建最小堆
            sift(keys, 0, i - 1);
        }

    }


    private static void sift(int[] keys, int parent, int end) {

        int child = 0;
        int parentValue = keys[parent];

        while (parent * 2 + 1 <= end) {
            child = parent * 2 + 1;

            if (child < end && keys[child] > keys[child + 1]) {
                //左右子树，选择较小的，构建最小堆
                child++;
            }
            //子节点大于父节点，则满足最小堆的要求
            if (keys[child] >= parentValue) {
                break;
            }
            //否则，将子节点赋给父节点
            keys[parent] = keys[child];
            parent = child;
        }
        keys[child] = parentValue;


    }


}




