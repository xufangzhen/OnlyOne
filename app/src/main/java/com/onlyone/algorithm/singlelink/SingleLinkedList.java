package com.onlyone.algorithm.singlelink;

public class SingleLinkedList<T> {

    Node<T> mHeadNode;
    Node<T> mEndNode;

    public SingleLinkedList(T head) {
        mHeadNode = new Node<>(head);
        mEndNode = mHeadNode;
    }

    private Node<T> getNodeByIndex(int index) {
        if (mHeadNode == null) {
            return null;
        }
        Node<T> temp = mHeadNode;
        int i = 0;
        while (temp != null && i < index) {
            temp = temp.next();
            i++;
        }
        if (i < index) {
            return null;
        } else {
            return temp;
        }
    }

    public T getByIndex(int index) {
        if (getNodeByIndex(index) == null) {
            return null;
        } else {
            return getNodeByIndex(index).getDate();
        }
    }

    public void deleteByIndex(int index) {
        if (mHeadNode == null || size() <= index) {
            return;
        }
        if (index == 0) {
            mHeadNode = mHeadNode.next();
            return;
        }

        Node<T> preTemp = mHeadNode;
        Node<T> temp = mHeadNode.next();

        for (int i = 1; temp != null; i++) {
            if (i == index) {
                preTemp.add(temp.next());
                break;
            }
            preTemp = preTemp.next();
            temp = temp.next();
        }
    }

    public void add(T date) {
        mEndNode.add(new Node<>(date));
        mEndNode = mEndNode.next();
    }

    public void addByIndex(T date, int index) {
        if (mHeadNode == null || size() < index) {
            return;
        }

        if (index == 0) {
            return;
        }

        Node<T> temp = mHeadNode;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next();
        }

        Node<T> temp2 = new Node<>(date);
        temp2.add(temp.next());
        temp.add(temp2);
    }

    public int size() {
        Node<T> temp = mHeadNode;
        int i = 0;
        for (; temp != null; i++) {
            temp = temp.next();
        }
        return i;
    }

    public String traverse() {
        Node<T> temp = mHeadNode;
        StringBuffer stringBuffer = new StringBuffer();
        while (temp != null) {
            stringBuffer.append(temp.getDate().toString()).append(" --> ");
            temp = temp.next();
        }
        return stringBuffer.toString();
    }


}

