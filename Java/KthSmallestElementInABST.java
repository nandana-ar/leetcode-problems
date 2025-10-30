//------------------------------PROBLEM 230--------------------------------//
//                    KTH SMALLEST ELEMENT IN A BST                        //


// Logic:
// - Define a count variable to track the number of nodes visited
// - Define a result variable to store the kth smallest value
// - Define a kTh variable to store the target k value
// - Call a helper function inOrderTraversal with the root node
// - In inOrderTraversal:
//   - If the current node is null, return false
//   - Recursively call inOrderTraversal for the left child
//   - Increment the count variable
//   - If count equals kTh, set result to the current node's value and 
//     return true
//   - Recursively call inOrderTraversal for the right child
// - Return the result variable


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
    int count = 0;
    int result = 0;
    int kTh = 0;

    public int kthSmallest(TreeNode root, int k) {
        kTh = k;
        inOrderTraversal(root);
        return result;
    }

    public boolean inOrderTraversal(TreeNode node) {
        if (node == null) {
            return false;
        }

        if (inOrderTraversal(node.left)){
            return true; 
        }

        count++;
        if (count == kTh) {
            result = node.val;
            return true;
        }
        
        return inOrderTraversal(node.right);
    }
}


// Time Complexity:
// - Each node is visited exactly once in the worst case: 
//                                       O(n) where n = number of nodes
// - In the average case for a balanced BST, the time complexity is
//                                       O(h + k) where h = height of tree
