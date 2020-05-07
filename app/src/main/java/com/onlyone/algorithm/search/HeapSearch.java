package com.onlyone.algorithm.search;

import java.util.PriorityQueue;

public class HeapSearch {

    //无序数组中查找第K大值
    public static int searchK(int[] data, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        //构建大小为k的小顶堆,时间复杂度 O(k)
        for (int i = 0; i < k; i++) {
            queue.offer(data[i]);
        }

        //时间复杂度 你n*log(k)
        int curValue = queue.poll();
        for (int i = k; i < data.length; i++) {
            if (curValue < data[i]) {
                queue.offer(data[i]);
                curValue = queue.poll();
            }
        }
        return curValue;
    }


}
