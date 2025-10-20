//------------------------------PROBLEM 100-------------------------------//
//                               SAME TREE                                //


// Logic: 
// If both nodes are null (the same), return true
// If one node is null and the other is not (not the same), return false
// If the values of the current nodes are different, return false
// Call the function recursively for the left children and right children of 
// both nodes
// Return true only if both recursive calls return true


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
    public boolean isSameTree(Treenode p, Treenode q) {
        if(p == null && q == null) {
            return true; 
        }

        if((p == null && q !=null ) || (p != null && q == null)) {
            return false; 
        }

        if(p.val != q.val) {
            return false; 
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}
