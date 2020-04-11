package com.onlyone.algorithm.leecode;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent347 {


    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Integer> topKFrequent(int[] nums, int k) {

        //用hashmap保存每值出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int key = nums[i];
            int value = 1;
            if (map.containsKey(key)) {
                value += map.get(key);
            }
            map.put(key, value);
        }
        //用优先队列获取第K个大的值
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue((Comparator<Map.Entry<Integer, Integer>>) (o1, o2) -> o2.getValue() - o1.getValue());
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            resultList.add(priorityQueue.poll().getKey());
        }
        return resultList;
    }
}
