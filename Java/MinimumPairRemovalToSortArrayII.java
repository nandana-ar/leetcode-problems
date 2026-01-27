//------------------------------PROBLEM 3510-------------------------------//
//                  MINIMUM PAIR REMOVAL TO SORT ARRAY II                  //


// Logic:
// NOTE: Same problem as Minimum Pair Removal To Sort Array I with optimized 
// approach
// -> If the length of the input array nums is less than or equal to 1, 
//    return 0
// -> Initialize an array val to store the values of nums as long integers
// -> Initialize two arrays left and right to keep track of the left and 
//    right neighbors of each element
// -> Using a for loop, populate the left and right arrays
// -> Create a PriorityQueue to store pairs of adjacent elements along with
//    their sums    [sum, leftmost_index]
// -> Sort the PriorityQueue based on the sum, and in case of ties, by the
//    leftmost_index
// -> Initialize a variable badCount to count the number of local inversions in
//    the array (places where an element is greater than its right neighbor)
// -> Using a for loop, populate the PriorityQueue with sums of adjacent
//    elements and update badCount accordingly
// -> Initialize a variable operations to count the number of operations
// -> While badCount is greater than 0 and the PriorityQueue is not empty:
//    - Poll the top element from the PriorityQueue
//    - Extract the sum and the leftmost index i from the polled element
//    - Determine the right index j using the right array
//    - Check if the pair (i, j) is still valid by verifying their adjacency 
//      and sum
//    - If valid, update badCount by removing old local inversions
//      - Determine the previous and next indices using the left and right arrays
//      - Decrease badCount for any local inversions involving the pair (i, j)
//    - Perform the merge by updating val[i] to the sum and adjusting the
//      left and right arrays
//    - Increment operations by 1
//    - Update badCount with new local inversions and add new pairs to the
//      PriorityQueue
//      - Check the previous and next indices for new local inversions
//      - Add new pairs formed with the merged element to the PriorityQueue
// -> Return operations as the result


class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        long[] val = new long[n];
        for (int i = 0; i < n; i++) val[i] = nums[i];

        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int badCount = 0;
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new long[]{val[i] + val[i + 1], i});
            if (val[i] > val[i + 1]) badCount++;
        }

        int operations = 0;
        while (badCount > 0 && !pq.isEmpty()) {
            long[] top = pq.poll();
            long sum = top[0];
            int i = (int) top[1];
            int j = right[i];

            if (j >= n || left[j] != i || val[i] + val[j] != sum) continue;

            if (val[i] > val[j]) badCount--;
            int prev = left[i];
            if (prev != -1 && val[prev] > val[i]) badCount--;
            int next = right[j];
            if (next != n && val[j] > val[next]) badCount--;

            val[i] = sum;
            right[i] = next;
            if (next != n) left[next] = i;
            operations++;

            if (prev != -1 && val[prev] > val[i]) badCount++;
            if (next != n) {
                if (val[i] > val[next]) badCount++;
                pq.offer(new long[]{val[i] + val[next], i});
            }
            if (prev != -1) {
                pq.offer(new long[]{val[prev] + val[i], prev});
            }
        }

        return operations;
    }
}


// Time Complexity:
// - Initializing arrays and populating the PriorityQueue: O(n log n)
// - Polling from the PriorityQueue and processing each pair: O(n) * O(log n)
// Overall, O(n log n) + O(n log n) 
// => O(n log n) where n = length of nums array