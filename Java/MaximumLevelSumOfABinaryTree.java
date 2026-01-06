//------------------------------PROBLEM 1161------------------------------//
//                    MAXIMUM LEVEL SUM OF A BINARY TREE                  //


// Logic:
// -> Initialize variables to keep track of the level which has the maximum 
//    sum, the current level during traversal, and the maximum sum found so far
// -> Use a queue to perform a level-order traversal (BFS) of the binary tree
// -> While the queue is not empty:
//    - Determine the number of nodes at the current level (levelSize)
//    - Initialize a variable to keep track of the sum of values at the 
//      current level
//    - For each node at the current level:
//      - Dequeue the node from the front of the queue
//      - Add its value to the current level sum
//      - If the node has a left child, enqueue it
//      - If the node has a right child, enqueue it
//    - After processing all nodes at the current level, compare the current 
//      level sum with the maximum sum found so far
//      - If the current level sum is greater than the maximum sum, then update
//        the maximum sum and record the current level as the maximum level
//    - Increment the current level counter
// -> Return the maximum level


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
    public int maxLevelSum(TreeNode root) {

        int maxLevel = 1; 
        int currLevel = 1; 
        int maxSum = Integer.MIN_VALUE;

        if(root == null) {
            return -1; 
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            if(levelSum > maxSum) {
                maxSum = levelSum; 
                maxLevel = currLevel;
            }

            currLevel+=1; 
        }  
    
        return maxLevel; 
    }
}


// Time Complexity:
// -> Initializing variables and queue: O(1)
// -> Level-order traversal of the binary tree: O(n)
//   where n is the number of nodes in the tree
// -> Each node is processed exactly once
// Overall, O(n) * O(1)
// => O(n)