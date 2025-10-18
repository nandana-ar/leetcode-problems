//------------------------------PROBLEM 110-------------------------------//
//                         BALANCED BINARY TREE                           //


// Logic:
// -> Define a helper class BalanceStatusWithHeight to store balance 
//    status and height of a subtree
// -> Create a recursive function checkBalance that returns the balance
//    status and height of a subtree
// -> For each node: 
//    - if it is null, return balanced with height -1
//    - recursively check the left and right subtrees
//    - determine if the current node is balanced based on its subtrees
//    - calculate the height of the current node
// -> The main function isBalanced calls checkBalance on the root and 
//    returns the balance status


/* TreeNode class is already defined hence it is commented out 
public class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}*/


import java.util.*;

public class BalancedBinaryTree {

    private static class BalanceStatusWithHeight {
        boolean balanced;
        int height;

        BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    private BalanceStatusWithHeight checkBalance(TreeNode node) {
        if (node == null) {
            return new BalanceStatusWithHeight(true, -1);
        }

        BalanceStatusWithHeight left = checkBalance(node.left);
        BalanceStatusWithHeight right = checkBalance(node.right);

        boolean isBalanced = left.balanced && right.balanced
                && Math.abs(left.height - right.height) <= 1;

        int height = Math.max(left.height, right.height) + 1;

        return new BalanceStatusWithHeight(isBalanced, height);
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).balanced;
    }
}


// Time Complexity:
// -> Each node is visited once (Recursion): O(n)
// -> Assignment and comparison operations : O(1)
// => O(n)