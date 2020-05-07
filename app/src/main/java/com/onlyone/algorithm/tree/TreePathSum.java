package com.onlyone.algorithm.tree;

public class TreePathSum {

    //利用先序计算树中任意节点到任意节点的最大值
    public boolean main(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {


        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val
                && isSymmetric(node1.left, node2.right)
                && isSymmetric(node1.right, node2.left);


    }

}
