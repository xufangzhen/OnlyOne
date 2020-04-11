package com.onlyone.algorithm.tree;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraverse {


    //深度遍历，使用stack
    public static void traverse1(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> nodeList = new Stack<>();
        nodeList.push(node);

        while (!nodeList.isEmpty()) {
            TreeNode popNode = nodeList.pop();
            Log.e("TreeTraverse", "value = " + popNode.value);
            if (popNode.leftTreeNode != null) {
                nodeList.push(popNode.leftTreeNode);
            }
            if (popNode.rightTreeNode != null) {
                nodeList.push(popNode.rightTreeNode);
            }
        }
    }


    //广度遍历，使用Queue
    public static void traverse2(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.offer(node);

        while (!nodeList.isEmpty()) {
            TreeNode popNode = nodeList.poll();
            Log.e("TreeTraverse", "value = " + popNode.value);
            if (popNode.leftTreeNode != null) {
                nodeList.offer(popNode.leftTreeNode);
            }
            if (popNode.rightTreeNode != null) {
                nodeList.offer(popNode.rightTreeNode);
            }
        }
    }


    //广度遍历，并且返回树的高，使用Queue
    public static int traverse3(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.offer(node);
        int deep = 0;

        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            deep++;

            for (int i = 0; i < size; i++) {
                TreeNode popNode = nodeList.poll();
                if (popNode.leftTreeNode != null) {
                    nodeList.offer(popNode.leftTreeNode);
                }
                if (popNode.rightTreeNode != null) {
                    nodeList.offer(popNode.rightTreeNode);
                }
            }
        }
        return deep;
    }


    //递归、先序
    public static void traverse4(TreeNode node) {
        if (node == null) {
            return;
        }
        Log.e("TreeTraverse", "value = " + node.value);
        if (node.leftTreeNode != null) {
            traverse4(node.leftTreeNode);
        }
        if (node.rightTreeNode != null) {
            traverse4(node.rightTreeNode);
        }
    }


    //递归、先序
    public static void traverse5(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.leftTreeNode != null) {
            traverse5(node.leftTreeNode);
        }
        Log.e("TreeTraverse", "value = " + node.value);

        if (node.rightTreeNode != null) {
            traverse5(node.rightTreeNode);
        }
    }

    //递归、先序
    public static void traverse6(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.leftTreeNode != null) {
            traverse6(node.leftTreeNode);
        }
        if (node.rightTreeNode != null) {
            traverse6(node.rightTreeNode);
        }
        Log.e("TreeTraverse", "value = " + node.value);
    }

}
