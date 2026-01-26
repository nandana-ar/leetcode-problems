//------------------------------PROBLEM 3507-------------------------------//
//                   MINIMUM PAIR REMOVAL TO SORT ARRAY I                  //


// Logic:
// -> Create an ArrayList and store the elements of the input array nums
// -> Initialize a counter operationsCount to 0 to keep track of the number 
//    of operations
// -> While the ArrayList is not sorted (using the isSorted helper function):
//    - Initialize sum to Integer.MAX_VALUE and index to 0
//    - Iterate through the ArrayList to find the pair of adjacent elements
//      with the smallest sum:
//      - For each pair, calculate their sum
//      - If this sum is less than the current minimum sum, update sum and index
//    - Remove the two elements at index and index + 1 from the ArrayList
//    - Add their sum back to the ArrayList at the original index
//    - Increment operationsCount by 1
// -> Return operationsCount as the result
//
// -> isSorted helper function:
//    - Iterate through the ArrayList and check if each element is less than or
//      equal to the next element
//    - If any element is greater than the next, return false
//    - If the loop completes, return true


class Solution {
    public int minimumPairRemoval(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }

        int operationsCount = 0; 
        while(!isSorted(list)){
            int sum = Integer.MAX_VALUE; 
            int index = 0; 
            int n = list.size();

            for(int i = 0; i + 1 < n; i++) {
                int newSum = list.get(i) + list.get(i + 1);
                if(sum > newSum) {
                    index = i; 
                    sum = newSum;
                }
            }

            list.remove(index + 1);
            list.remove(index);
            list.add(index, sum);

            operationsCount+=1;

        }

        return operationsCount;

    }


    public boolean isSorted(ArrayList<Integer> list) {

        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i+1)) {
                return false; 
            }
        }

        return true;

    }
}


// Time Complexity:
// - Outer while loop: Runs at most O(n) times as the list size decreases by 1 per step
// - Inside the loop:
//   - isSorted(list): O(n)
//   - Finding the minimum sum pair: O(n)
//   - list.remove() and list.add(): O(n) due to element shifting in ArrayList
// Overall, O(n) * (O(n) + O(n) + O(n)) 
// => O(n^2)
