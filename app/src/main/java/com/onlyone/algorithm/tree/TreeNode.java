package com.onlyone.algorithm.tree;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public static TreeNode buildTree() {

        TreeNode[] nodeList = new TreeNode[10];

        for (int i = 0; i < 10; i++) {
            TreeNode node = new TreeNode();
            node.val = i+1;
            nodeList[i] = node;
        }

        nodeList[0].left = nodeList[1];
        nodeList[0].right = nodeList[4];

        nodeList[1].left = nodeList[2];
        nodeList[1].right = nodeList[3];

        nodeList[4].right = nodeList[5];

        return nodeList[0];

    }

    private void sort(int[] data) {
        if (data == null || data.length < 1) {
            return;
        }
        for (int i = 0, length = data.length; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (data[i] < data[j]) {
                    data[i] = data[i] ^ data[j];
                    data[j] = data[i] ^ data[j];
                    data[i] = data[i] ^ data[j];
                }
            }
        }
    }

}
