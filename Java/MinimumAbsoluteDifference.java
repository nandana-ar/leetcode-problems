//------------------------------PROBLEM 1200-------------------------------//  
//                     MINIMUM ABSOLUTE DIFFERENCE                         //


// Logic:
// -> Sort the input array arr in non-decreasing order
// -> Initialize a variable minDiff to keep track of the minimum absolute 
//    difference
// -> Create a result list of lists to store pairs with the minimum difference
// -> Iterate through the sorted array from index 1 to the end:
//    - Calculate the difference between the current element and the previous 
//      element
//    - If the difference is greater than minDiff, continue to the next iteration
//    - If the difference is less than minDiff, clear the result list and
//      update minDiff to the current difference
//    - Add the pair [arr[i - 1], arr[i]] to the result list
// -> Return the result list containing all pairs with the minimum absolute 
//    difference


class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); 
        int minDiff = Integer.MAX_VALUE; 

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i < arr.length; i++) {
            
            int difference = arr[i] - arr[i - 1];

            if(difference > minDiff) {
                continue; 
            } 
            
            if (difference < minDiff) {
                result.clear();
                minDiff = difference; 
            }

            result.add(Arrays.asList(arr[i - 1], arr[i]));
             
        }

        return result; 
        
    }
}


// Time Complexity:
// -> Sorting the array: O(n log n)
// -> Single pass to find minimum absolute difference: O(n)
// Overall, O(n log n) + O(n)
// => O(n log n)