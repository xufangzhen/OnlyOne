package com.onlyone.algorithm.tree;

public class TreeNode {


    int value;
    TreeNode leftTreeNode;

    TreeNode rightTreeNode;


    public static TreeNode buildTree() {

        TreeNode[] nodeList = new TreeNode[10];

        for (int i = 0; i < 10; i++) {
            TreeNode node = new TreeNode();
            node.value = i;
            nodeList[i] = node;
        }

        nodeList[0].leftTreeNode = nodeList[1];
        nodeList[0].rightTreeNode = nodeList[2];

        nodeList[1].rightTreeNode = nodeList[3];

        nodeList[2].leftTreeNode = nodeList[4];
        nodeList[2].rightTreeNode = nodeList[5];

        nodeList[3].leftTreeNode = nodeList[6];
        nodeList[3].rightTreeNode = nodeList[7];

        nodeList[5].leftTreeNode = nodeList[8];
        nodeList[5].rightTreeNode = nodeList[9];

        return nodeList[0];

    }

}
