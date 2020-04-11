package com.onlyone.algorithm.queue;

import android.util.Log;

import java.util.PriorityQueue;

public class QueueDemo {


    public static void print() {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);

        // Remove items from the Priority Queue (DEQUEUE)
        while (!numbers.isEmpty()) {
            Log.e("xfz","");
            System.out.println(numbers.remove());
        }
    }



}
