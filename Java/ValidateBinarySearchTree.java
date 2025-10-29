//------------------------------PROBLEM 98---------------------------------//
//                      VALIDATE BINARY SEARCH TREE                        //


// Logic:
// - Call a helper function isValid with the root node, minimum value, and 
//   maximum value
// - In isValid:
//   - If the current node is null, return true (base case)
//   - If the current node's value is less than or equal to min or greater
//     than or equal to max, return false
//   - Recursively call isValid for the left child with updated max value
//     and for the right child with updated min value
//   - Return true only if both recursive calls return true
// - Return the result of the initial isValid call


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

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValid(node.left, min, node.val) && 
               isValid(node.right, node.val, max);
    }
}


// Time Complexity:
// - Each node is visited exactly once: O(n) where n = number of nodes
