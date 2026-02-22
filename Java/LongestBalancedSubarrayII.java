//----------------------------PROBLEM 3721--------------------------------//
//                   LONGEST BALANCED SUBARRAY II                         //


// Logic:
// NOTE: This problem is a more optimized version problem 3719 where 
// we use a segment tree to efficiently track the balance of odd and even 
// numbers in the subarrays
// -> SegmentTree class: 
//   - Set variable n to the length of the input array
//   - Create three arrays: minTree, maxTree, and lazy 
//   - Set each of thse arrays to have a size of 4 * n to accommodate the segment 
//     tree structure
//   - push method:
//     - If there are pending updates in the lazy array of the current node,
//       apply them to the minTree and maxTree arrays  of the current node
//     - If the start and end indices are not the same, propagate the lazy updates 
//       to the child nodes at indices 2 * node and 2 * node + 1
//     - Set the lazy value of the current node to 0 after applying the updates
//   - updateRange method:
//     - Push any pending updates for the current node
//     - If the start index is greater than the end index or if the current segment 
//       is outside the given range [l, r], return without making any updates
//     - If the current segment is fully within the range [l, r], update the lazy
//       value for the current node and push the updates and return
//     - Otherwise, set mid to the midpoint of the current segment and recursively 
//       call updateRange for the left and right child nodes
//     - After updating the child nodes, update the minTree and maxTree values for
//       the current node based on the values of its child nodes
//   - findLeftmostZero method:
//     - Push any pending updates for the current node
//     - If the minimum value in the current segment is greater than 0 or if the
//       maximum value is less than 0, return -1 as there are no balanced subarrays
//     - If the start and end indices are the same, return the index
//       - If the value of that index is 0, it means we have found a balanced subarray, 
//         so return the index
//       - Otherwise, return -1
//     - Otherwise, set mid to the midpoint of the current segment and recursively call
//       findLeftmostZero for the left child node
//     - If the left child node returns a valid index, return that index
//     - Otherwise, call findLeftmostZero for the right child node and return its result
// -> longestBalanced method:
//  - Initialise a HashMap prev to keep track of the last occurrence of each number in 
//    the input array
//  - Create an instance of the SegmentTree class with the size of the input array
//  - Initialize a variable res to keep track of the longest balanced subarray length
//  - Iterate through the input array using a variable r as the right pointer:
//    - For each element at index r, determine if it is odd or even
//    - If the element is even, set val to 1; if it is odd, set val to -1
//    - If the current element has been seen before (exists in the prev HashMap):
//      - Update the segment tree to remove the contribution of the previous occurrence
//        by calling updateRange with the range from 0 to the last occurrence index and 
//        the value -val
//    - Update the segment tree to add the contribution of the current element by calling
//      updateRange with the range from 0 to r and the value val
//    - Update the prev HashMap with the current index for the current element
//    - Call findLeftmostZero on the segment tree to find the leftmost index l where the
//      balance is zero (indicating a balanced subarray)
//    - If a valid index l is found and it is less than or equal to r, update res with
//      the maximum of res and the length of the current balanced subarray (r - l + 1)
//  - Return res as the length of the longest balanced subarray found


class SegmentTree {
    int n;
    int[] minTree, maxTree, lazy;

    public SegmentTree(int n) {
        this.n = n;
        minTree = new int[4 * n];
        maxTree = new int[4 * n];
        lazy = new int[4 * n];
    }

    private void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            minTree[node] += lazy[node];
            maxTree[node] += lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    public void updateRange(int node, int start, int end, int l, int r, int val) {
        push(node, start, end);
        if (start > end || start > r || end < l) {
            return;
        }
        if (l <= start && end <= r) {
            lazy[node] += val;
            push(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);
        minTree[node] = Math.min(minTree[2 * node], minTree[2 * node + 1]);
        maxTree[node] = Math.max(maxTree[2 * node], maxTree[2 * node + 1]);
    }

    public int findLeftmostZero(int node, int start, int end) {
        push(node, start, end);
        if (minTree[node] > 0 || maxTree[node] < 0) {
            return -1;
        }
        if (start == end) {
            return minTree[node] == 0 ? start : -1;
        }
        int mid = (start + end) / 2;
        int left = findLeftmostZero(2 * node, start, mid);
        if (left != -1) return left;
        return findLeftmostZero(2 * node + 1, mid + 1, end);
    }
}

public class LongestBalancedSubarrayII {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> prev = new HashMap<>();

        SegmentTree st = new SegmentTree(n);
        int res = 0;

        for (int r = 0; r < n; r++) {
            int v = nums[r];
            int val = (v % 2 == 0) ? 1 : -1;

            if (prev.containsKey(v)) {
                st.updateRange(1, 0, n - 1, 0, prev.get(v), -val);
            }

            st.updateRange(1, 0, n - 1, 0, r, val);
            prev.put(v, r);

            int l = st.findLeftmostZero(1, 0, n - 1);
            if (l != -1 && l <= r) {
                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }
}


// Time Complexity:
// -> Initialising HashMap: O(1)
// -> Initialising Segment Tree: O(n)
// -> Iterating through the input array: O(n)
// -> For each element, we may update the segment tree: O(log n)
// -> Finding the leftmost zero in the segment tree: O(log n)
// Overall, O(n) * O(log n)
//=> O(n log n)