package com.onlyone.algorithm.singlelink;

public class Node<T> {

    private T mDate;
    private Node<T> mNext;

    public Node(T date) {
        mDate = date;
    }

    public T getDate() {
        return mDate;
    }

    public void add(Node<T> node) {
        mNext = node;
    }

    public Node<T> next() {
        return mNext;
    }

    public String toString() {
        return mDate.toString();
    }
}
