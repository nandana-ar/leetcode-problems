//------------------------------PROBLEM 199--------------------------------//
//                      BINARY TREE RIGHT SIDE VIEW                        //


// Logic:
// - Create a result list to hold the right side view nodes
// - Create a queue for BFS
// - If the root node is null, return the empty result list
// - Add the root node to the queue
// Using BFS:
// - While the queue is not empty:
//   - Determine the number of nodes at the current level (levelSize)
//   - For each node at the current level:
//     - Dequeue a node from the front of the queue
//     - If the node has a left child, enqueue it   ------|
//     - If the node has a right child, enqueue it  ------|
//                                                        v
//   (adds the children of the current node to the queue for the next level)
//     - If this is the last node at the current level (i == levelSize - 1),
//       add its value to the result list
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result; 
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size(); 
             for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                if(currentNode.left != null) {
                    queue.add(currentNode.left); 
                }

                if(currentNode.right != null) {
                    queue.add(currentNode.right); 
                }

                if(i == levelSize-1) {
                    result.add(currentNode.val);
                }

             }
        } 

        return result; 
  
    }
}


// Time Complexity:
// - Each node is processed exactly once: O(n) where n = number of nodes
