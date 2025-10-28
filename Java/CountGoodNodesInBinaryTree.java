//------------------------------PROBLEM 1448-------------------------------//
//                   COUNT GOOD NODES IN BINARY TREE                       //


// Logic:
// - Initialize a result counter to 0
// - If the root node is null, return 0
// - Use a helper function, countNodes, to perform DFS traversal
// - In countNodes:
//   - If the current node is null, return 0
//   - Initialize a count variable to 0
//   - If the current node's value is greater than or equal to maxSoFar,
//     increment the count
//   - Update maxSoFar to be the maximum of maxSoFar and the current node's value
//   - Recursively call countNodes for the left and right children,
//     passing the updated maxSoFar
//   - Add the counts from the left and right subtrees to the current count
//   - Return the count
// - Return the final count


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
    public int goodNodes(TreeNode root) {
        int result = 0; 

        if(root == null) {
            return result;
        }

        result = countNodes(root, root.val); 
        
        return result;  
    }

    public int countNodes(TreeNode currentNode, int maxSoFar) {
        if(currentNode == null) {
            return 0; 
        }

        int count = 0; 

        if(currentNode.val >= maxSoFar) {
            count++; 
        }

        maxSoFar = Math.max(maxSoFar, currentNode.val);

        int leftCount = countNodes(currentNode.left, maxSoFar); 
        int rightCount = countNodes(currentNode.right, maxSoFar); 

        count += leftCount; 
        count += rightCount; 

        return count; 
    }
}


// Time Complexity: 
// - Each node is visited exactly once: O(n) where n = number of nodes
