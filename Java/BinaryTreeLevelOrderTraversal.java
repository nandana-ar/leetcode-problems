//------------------------------PROBLEM 102-------------------------------//
//                    BINARY TREE LEVEL ORDER TRAVERSAL                   //


// Logic:
// - Create a result list to hold the final level order traversal
// - If the root is null, return the empty result list
// - Initialize a queue and add the root node to it
// Using BFS:
// - While the queue is not empty:
//   - Determine the number of nodes at the current level (levelSize)
//   - Create a list to hold the values of nodes at the current level 
//     (currentLevel)
//   - For each node at the current level:
//     - Dequeue a node from the front of the queue
//     - Add its value to the currentLevel list
//     - If the node has a left child, enqueue it
//     - If the node has a right child, enqueue it
//   - Add the currentLevel list to the result list
// - Return the result list


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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(); 

        if(root == null) {
            return result; 
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size(); 
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); 
                currentLevel.add(currentNode.val);

                if(currentNode.left != null) {
                    queue.add(currentNode.left); 
                }

                if(currentNode.right != null) {
                    queue.add(currentNode.right); 
                }
            }

            result.add(currentLevel);
        }

        return result;    
    }
}


// Time Complexity:
// - Each node is processed exactly once: O(n) where n = number of nodes
