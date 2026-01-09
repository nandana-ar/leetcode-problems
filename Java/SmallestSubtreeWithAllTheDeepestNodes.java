//------------------------------PROBLEM 865-------------------------------//
//               SMALLEST SUBTREE WITH ALL THE DEEPEST NODES              //


// Logic:  
// -> Helper class Result:
//   - Holds the depth and node information
// -> Helper function dfs:
//   - If the current node is null, return depth 0 and null node
//   - Recursively call dfs on the left and right children to get their
//     depths and nodes
//   - Compare the depths of the left and right subtrees
//     - If left depth is greater, return left depth + 1 and left node
//     - If right depth is greater, return right depth + 1 and right node
//     - Else if both depths are equal, return left depth + 1 and the current
//       node (as it is the common ancestor of deepest nodes)
// -> Main function subtreeWithAllDeepest:
//   - Call the dfs function on the root and return the node from the result


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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private static class Result {
        int depth;
        TreeNode node;

        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    private Result dfs(TreeNode root) {

        if (root == null) {
            return new Result(0, null);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        }

        if (right.depth > left.depth) {
            return new Result(right.depth + 1, right.node);
        }

        return new Result(left.depth + 1, root);
    }

}


// Time Complexity:
// -> Each node is visited once in the DFS traversal: O(n)
//   where n is the number of nodes in the tree 
//=> O(n)