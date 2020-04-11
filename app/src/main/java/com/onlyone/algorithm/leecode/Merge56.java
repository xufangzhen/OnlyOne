package com.onlyone.algorithm.leecode;

import java.util.Arrays;

public class Merge56 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        //排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[] pre = intervals[0];
        int[] cur;
        int delete = 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            cur = intervals[i + 1];
            //前一个的后区间比当前的前区间大，需要合并
            while (pre[1] > cur[0]) {
//               //需要删除
                delete++;
                i++;
                if (i >= intervals.length - 1) {
                    cur = null;
                    break;
                }
                if (pre[1] >= cur[1]) {
                    pre = cur;
                }
                cur = intervals[i + 1];
            }
            pre = cur;
        }
        return delete;
    }


}
