package com.onlyone.algorithm.sort.swap;

public class BubbleSort {

//    时间复杂度：
//    最好情况（待排序列接近无序）时间复杂度为O(n)，
//    最坏情况（待排序列接近有序）时间复杂度为O(n2)，
//    平均时间复杂度为O(n2).

    //    int[] keys = {81, 49, 19, 38, 97, 76, 13};

    public static void sort(int[] dates) {
        int length = dates.length;
        boolean needSort = true;
        for (int i = 1; i < length && needSort; i++) {
            needSort = false;
            for (int j = 0; j < length - i; j++) {
                if (dates[j] > dates[j + 1]) {
                    int temp = dates[j];
                    dates[j] = dates[j + 1];
                    dates[j + 1] = temp;
                    needSort = true;
                }
            }
        }
    }


}



 /*   //冒泡
    private void sort(int[] data){
        if(data == null || data.length < 1){
            return;
        }
        boolean needSort;
        for(int i=1,len = data.length;i<length && needSort; i++){
            needSort = false;
            for(int j=0; j< len - i; j++){
                if(data[j] > date[j+1]){
                    data[j] = data[j] ^ date[j + 1];
                    data[j + 1] = data[j] ^ date[j + 1];
                    data[j] = data[j] ^ date[j + 1];
                    needSort = true;
                }
            }
        }
    }*/
