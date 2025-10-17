//------------------------------PROBLEM 543-------------------------------//
//                         DIAMETER OF BINARY TREE                        //


// Logic:
// -> Use a helper function to calculate the height of the tree
// -> For each node, calculate the height of its left and right subtrees
// -> The diameter at that node is the sum of the heights of the left and
//    right subtrees
// -> Update the maximum diameter found so far
// -> Return the height of the current node as 1 + max(leftHeight, rightHeight)
// -> The final diameter is stored in a global variable
// -> Return the maximum diameter after traversing the entire tree


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


import java.util.*;

class Solution {

    int maxDiameter = 0; 

    public int diameterOfBinaryTree(TreeNode root) {

        height(root); 

        return maxDiameter; 
    }

    public int height(TreeNode root) {
        if(root == null) 
            return 0; 

        int leftDepth = height(root.left); 
        int rightDepth = height(root.right); 

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth); 
    }
}


// Time Complexity:
// -> Each node is visited once: O(n)
//=> O(n)