//------------------------------PROBLEM 347------------------------------//
//                        TOP K FREQUENT ELEMENTS                        //


//Logic:
// -> Create a frequency map to count occurrences of each number
// -> Use a priority queue as a min-heap 
// -> Iterate through the frequency map and add each entry to the heap
// -> In the heap, store pairs of (number, frequency)
// -> If the heap size exceeds k, remove the least frequent element
// -> At the end, extract the elements from the heap to form the result 
//    array and return it


import java.util.*; 

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (heap.size() > k) 
                heap.poll();
        }

        int[] result = new int[k];
        
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll()[0];
        }

        return result;
    }

}


//Time Complexity:
// -> Building the frequency map using for loop: O(n)
// -> For each element n in the frequency map:
//  - Adding to the heap: O(log k)
//  => O(n) * O(log k) = O(n log k) 
// -> For each of the k elements:
//  - Removing from the heap: O(log k)
//  => O(k) * O(log k) = O(k log k)
// Overall, O(n) + O(n log k) + O(k log k)
// => O(n log k)