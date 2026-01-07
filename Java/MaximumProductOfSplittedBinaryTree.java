//------------------------------PROBLEM 1339------------------------------//
//                 MAXIMUM PRODUCT OF SPLITTED BINARY TREE                //


// Logic:
// -> Intialise variables to keep track of total sum of tree nodes and 
//    maximum product found so far
// -> Define a constant MOD for modulo operation to handle large numbers
// -> Main function maxProduct:
//    - Compute the total sum of all nodes in the binary tree using helper
//      function computeTotalSum
//    - Compute the sum of each subtree and the corresponding product using
//      helper function computeSubtreeSum
//    - Return the maximum product found modulo MOD
// -> Helper function computeTotalSum: 
//    - If the current node is null, return 0
//    - Add the value of the current node to the sum of the left and right
//      subtrees (computed recursively)
//    - Return the total sum of the tree
// -> Helper function computeSubtreeSum:
//    - If the current node is null, return 0
//    - Recursively compute the sum of the left and right subtrees
//    - Calculate the sum of the current subtree (current node value + left
//      subtree sum + right subtree sum)
//    - Calculate the product using the formula: 
//          subtreeSum * (totalSum - subtreeSum)
//    - Update maxProduct if the calculated product is greater than the
//      current maxProduct
//    - Return the sum of the current subtree


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
    private long totalSum = 0; 
    private long maxProduct = 0; 
    private static final int MOD = 1000000007; 

    public int maxProduct(TreeNode root) {
        totalSum = computeTotalSum(root);
        computeSubtreeSum(root);
        
        return (int)(maxProduct % MOD); 
    }

    private long computeTotalSum(TreeNode node){
        if(node == null) {
            return 0; 
        }

        return node.val 
               + computeTotalSum(node.left) 
               + computeTotalSum(node.right);
    }

    private long computeSubtreeSum(TreeNode node){
        if(node == null) {
            return 0; 
        }

        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);

        long subtreeSum = node.val + leftSum + rightSum; 

        long product = subtreeSum * (totalSum - subtreeSum);
        
        maxProduct = Math.max(maxProduct, product); 

        return subtreeSum; 
    }

}


// Time Complexity:
// -> Both helper functions traverse each node exactly once: O(n)
//=> O(n)