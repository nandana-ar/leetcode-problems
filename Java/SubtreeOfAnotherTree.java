//------------------------------PROBLEM 572-------------------------------//
//                        SUBTREE OF ANOTHER TREE                         //


// Logic: 
// If both root and subRoot are null, return true
// If either root or subRoot is null (but not both), return false
// Otherwise, check if the trees rooted at the current nodes are the same 
// using isSameTree function
// If they are the same, return true
// If not, recursively check the left and right subtrees of root for subRoot


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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true; 
        }

        if(root == null || subRoot == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true; 
        }
        if((p == null && q != null) || (p != null && q == null)){
            return false; 
        }

        if(p.val != q.val) {
            return false; 
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 

    }
}