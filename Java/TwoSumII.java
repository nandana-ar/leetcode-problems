//------------------------------PROBLEM 167------------------------------//
//                   TWO SUM II - INPUT ARRAY IS SORTED                  //


//Logic:
// -> Use two pointers, one starting at the beginning (left) and the other 
//    at the end (right) of the array
// -> Calculate the sum of the numbers at the left and right pointers
// -> If the sum is equal to the target, return the indices, converted as 
//    1-indexed (left + 1, right + 1)
// -> If the sum is greater than the target, move the right pointer to the 
//    left (right--)
// -> If the sum is less than the target, move the left pointer to the
//    right (left++)
// -> Repeat the process until the left pointer is less than or equal to
//    the right pointer


class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0; 
        int right = numbers.length - 1; 
        int[] result = new int [2];

        while (left < right) {

            int sum = numbers[left] + numbers[right]; 

            if(sum == target){
                break; 
            } else if (sum > target){
                right --; 
            } else if (sum < target){
                left ++; 
            }

        }

        result[0] = left + 1; 
        result[1] = right + 1; 

        return result; 
    }
}


//Time Complexity:
// -> Using two pointers to traverse the array once (array is scanned from
//    both ends without resetting): O(n)
// Overall, O(n)
// => O(n)
