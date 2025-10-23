//------------------------------PROBLEM 101-------------------------------//
//                            SYMMETRIC TREE                              //


// Logic: 
// If the root is null, return true (an empty tree is symmetric)
// Use a helper function isMirror to compare the left and right subtrees
// In isMirror function:
// - If both left and right nodes are null (the same), return true
// - If one node is null and the other is not (not the same), return false
// - If the values of the current nodes are different, return false
// - Check if the left child of the left node is equal to the right child 
//   of the right node and the right child of the left node is equal to the 
//   left child of the right node
// - If they are equal, return true
// - Recursively check if the left child of the left node is a mirror of the
//   right child of the right node and the right child of the left node is a
//   mirror of the left child of the right node
// - Return true only if both recursive calls return true


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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true; 
        }

        if(isMirror(root.left, root.right)) {
            return true; 
        }

        return false;  
    }

    public boolean isMirror(TreeNode left, TreeNode right) {

        if(left == null && right == null) {
            return true; 
        }

        if((left == null && right !=null) || (left != null && right == null)) {
            return false; 
        }

        if(left.val != right.val) {
            return false; 
        }

        if(left.left == right.right && left.right == right.left) {
            return true;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }
}


// Time Complexity:
// Each node in the tree is visited once: O(n)
// Compare two nodes takes constant time: O(1)
// Overall, O(n)

