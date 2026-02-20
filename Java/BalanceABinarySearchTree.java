//----------------------------PROBLEM 1382--------------------------------//
//                   BALANCE A BINARY SEARCH TREE                         //


// Logic:
// -> Helper function inOrderTraversal:
//    - If the node is null, return 
//    - Else: 
//          - Recursively traverse the left subtree
//          - Add the node's value to the list
//          - Recursively traverse the right subtree 
// -> Helper function buildBalancedBST:
//    - If start index is greater than end index, return null
//    - Calculate the mid index mid = start + (end - start) / 2
//    - Create a new TreeNode with the value at mid index
//    - Recursively build the left subtree with the left half of the list
//    - Recursively build the right subtree with the right half of the list
//    - Return the created node
// -> Main function balanceBST:
//    - Create an empty list to store the sorted values
//    - Call inOrderTraversal to fill the list with values from the BST
//    - Call buildBalancedBST with the sorted list to create a balanced BST
//    - Return the root of the balanced BST


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

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }


    private TreeNode buildBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildBalancedBST(list, start, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, end);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedValues = new ArrayList<>();

        inOrderTraversal(root, sortedValues);
        
        return buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }
    
}


// Time Complexity:
// -> In-order traversal: O(n)
// -> Building balanced BST: O(n)
// -> Creating the list of sorted values: O(n)
// Overall, O(n) + O(n) + O(n) = O(n)
// => O(n)
