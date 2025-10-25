//------------------------------PROBLEM 235-------------------------------//
//              LOWEST COMMON ANCESTOR OF BINARY SEARCH TREE              //


// Logic: 
// If the root is null, return null
// If both p and q values are less than the root's value (LCA lies in the
// left subtree), recursively call the function on the left child
// If both p and q values are greater than the root's value (LCA lies in
// the right subtree), recursively call the function on the right child
// If neither of the above cases is true, the current root is the LCA,
// so return the root


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null; 
        }
        
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q); 
        }

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q); 
        }

        return root; 

    }
}


// Time Complexity: 
// - Each node is visited at most once: O(h) where h = height of the tree
// - Worst case (unbalanced tree - no left or right subtree): h = n => O(n)
// - Best case (balanced tree): h = log n => O(log n)
