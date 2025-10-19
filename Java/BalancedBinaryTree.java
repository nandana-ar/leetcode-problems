//------------------------------PROBLEM 110-------------------------------//
//                         BALANCED BINARY TREE                           //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
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


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic:
// -> Create a recursive function checkHeight that returns the height of
//    a subtree or -1 if it is unbalanced
// -> For each node:
//    - if it is null, return 0
//    - recursively check the heights of the left and right subtrees
//    - if either subtree is unbalanced, return -1
//    - if the difference in heights is greater than 1, return -1
//    - otherwise, return the height of the subtree
// -> The main function isBalanced calls checkHeight on the root
// -> Returns true if the tree is balanced (not -1), false otherwise


public class Solution {

    private int checkHeight(TreeNode node) {
        if(node == null) 
            return 0; 

        int leftHeight = checkHeight(node.left); 
        if(leftHeight == -1) 
            return -1; 

        int rightHeight = checkHeight(node.right); 
        if(rightHeight == -1) 
            return -1; 
    
        if (Math.abs(leftHeight - rightHeight) > 1) 
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
}


// Time Complexity:
// -> Each node is visited once (Recursion): O(n)
// -> Assignment and comparison operations : O(1)
// => O(n)

// Note: The second attempt is more space efficient as it does not require
// the additional BalanceStatusWithHeight class.