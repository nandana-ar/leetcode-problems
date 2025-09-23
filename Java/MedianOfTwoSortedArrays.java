//------------------------------PROBLEM 4--------------------------------//
//                     MEDIAN OF TWO SORTED ARRAYS                       //


//Logic: 
// -> Merge the two sorted arrays into one sorted array
// -> Calculate the median of the merged array
//    - If the length of the merged array is odd, the median is the middle
//      element
//    - If the length of the merged array is even, the median is the average
//      of the two middle elements
// -> Return the median rounded to five decimal places


import java.util.*; 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                                .sorted()
                                .toArray(); 
        
        double median = 0; 
        int half = merged.length / 2;

        if(merged.length % 2 == 0) {
            median = (merged[half -1] + merged[half]) / 2.0;
        } else { 
            median = merged[half]; 
        }

        return Math.round(median * 100000.0) / 100000.0; 
        
    }
}


//Time Complexity:
// -> Merging two arrays: O(m + n), where m and n are the lengths of the
//    two arrays
// -> Sorting the merged array: O((m + n) log(m + n))
// -> Finding the median: O(1)
// Overall, O((m + n) + O((m + n) log(m + n)) + O(1)
// => O((m + n) log(m + n))