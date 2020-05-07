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
            Log.e("TreeTraverse", "value = " + popNode.val);
            if (popNode.left != null) {
                nodeList.push(popNode.left);
            }
            if (popNode.right != null) {
                nodeList.push(popNode.right);
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
            Log.e("TreeTraverse", "value = " + popNode.val);
            if (popNode.left != null) {
                nodeList.offer(popNode.left);
            }
            if (popNode.right != null) {
                nodeList.offer(popNode.right);
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
                if (popNode.left != null) {
                    nodeList.offer(popNode.left);
                }
                if (popNode.right != null) {
                    nodeList.offer(popNode.right);
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
        Log.e("TreeTraverse", "value = " + node.val);
        if (node.left != null) {
            traverse4(node.left);
        }
        if (node.right != null) {
            traverse4(node.right);
        }
    }

    //递归、中序
    public static void traverse5(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            traverse5(node.left);
        }
        Log.e("TreeTraverse", "value = " + node.val);

        if (node.right != null) {
            traverse5(node.right);
        }
    }

    //递归、后序
    public static void traverse6(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            traverse6(node.left);
        }
        if (node.right != null) {
            traverse6(node.right);
        }
        Log.e("TreeTraverse", "value = " + node.val);
    }


}
