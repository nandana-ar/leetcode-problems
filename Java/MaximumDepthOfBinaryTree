//------------------------------PROBLEM 104-------------------------------//
//                       MAXIMUM DEPTH OF BINARY TREE                     //


// Logic:
// -> Base case: If the node is null, return 0
// -> Recursively call the function on the left and right children
// -> Return 1 + the maximum of the depths of the left and right subtrees
//    (the +1 accounts for the current node)

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
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) 
            return 0; 

        int leftDepth = maxDepth(root.left); 
        int rightDepth = maxDepth(root.right); 

        return 1 + Math.max(leftDepth, rightDepth); 

    }
}


//Time Complexity:
// -> Each node is visited once: O(n)
//=> O(n)