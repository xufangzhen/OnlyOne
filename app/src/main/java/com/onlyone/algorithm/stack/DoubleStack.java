package com.onlyone.algorithm.stack;

import java.util.Arrays;

public class DoubleStack {

    private int[] array;
    private int index1 = 0;
    private int index2 = 1;


    public DoubleStack(int length) {
        array = new int[length];
    }


    public void push1(int t) {
        if (index1 >= array.length) {
            resize();
        }
        array[index1] = t;
        index1 += 2;
    }

    public void push2(int t) {
        if (index2 >= array.length) {
            resize();
        }
        array[index2] = t;
        index2 += 2;
    }

    public int pop1() {
        if (index1 < 0) {
            return -1;
        }

        int value = array[index1];
        index1 -= 2;
        return value;
    }

    public int pop2() {
        if (index2 < 0) {
            return -1;
        }

        int value = array[index2];
        index2 -= 2;
        return value;
    }

    public void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }


}
