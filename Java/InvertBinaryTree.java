//------------------------------PROBLEM 226-------------------------------//
//                           INVERT BINARY TREE                           //


// Logic:
// -> Base case: If the node is null, return null
// -> Recursively call the function on the left and right children
// -> Swap the left and right children of the current node using a 
//    temporary variable
// -> Return the current node


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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) 
            return null; 
        
        invertTree(root.left); 
        invertTree(root.right); 

        TreeNode temp = root.left; 
        root.left = root.right; 
        root.right = temp; 

        return root;   
    }
}


//Time Complexity:
// -> Each node is visited once: O(n)
//=> O(n)