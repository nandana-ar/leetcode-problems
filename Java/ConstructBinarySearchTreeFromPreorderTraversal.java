//------------------------------PROBLEM 1008-------------------------------//
//           CONSTRUCT BINARY SEARCH TREE FROM PREORDER TRAVERSAL          //


// Logic:
// - Define an index variable to track the current position in the preorder 
//   array
// - Call a helper function buildBST with the preorder array, lower bound, 
//   and upper bound
// - In buildBST:
//   - If the index is equal to the length of the preorder array, return null
//   - Get the current value from the preorder array at the index
//   - If the value is less than the lower bound or greater than the upper
//     bound, return null
//   - Otherwise, create a new TreeNode with the current value
//   - Increment the index
//   - Recursively call buildBST for the left child with updated upper bound
//   - Recursively call buildBST for the right child with updated lower bound
//   - Return the created TreeNode
// - Return the result of the initial buildBST call


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
    int index = 0; 

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode buildBST(int[] preorder, int lower, int upper) {
        if (index == preorder.length) {
            return null; 
        }

        int value = preorder[index];

        if (value < lower || value > upper) {
            return null; 
        }

        TreeNode node = new TreeNode(value); 
        index += 1; 

        node.left = buildBST(preorder, lower, value); 
        node.right = buildBST(preorder, value, upper); 

        return node;   
    }
}


// Time Complexity:
// - Each node is created exactly once: O(n) where n = number of nodes
