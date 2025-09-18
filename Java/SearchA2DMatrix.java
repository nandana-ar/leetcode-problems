//------------------------------PROBLEM 74-------------------------------//
//                          SEARCH A 2D MATRIX                           //


// Logic: 
// -> Flatten the 2D matrix into a 1D array using a for loop
// -> Use binary search on the 1D array to find the target
// -> If found, return true
// -> Otherwise, return false


import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] fullMatrix = new int[matrix[0].length * matrix.length]; 
        int count = 0; 

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                fullMatrix[count] = matrix[i][j];
                count++; 

            }
        }

        int found = search(fullMatrix, target); 
        if(found != -1){
            return true;
        }
        return false;
        
    }

    public int search(int[] nums, int target) {
        int start = 0; 
        int end = nums.length - 1; 
        int middle = (int) (start + end )/2; 

        while(nums[middle] != target && start <= end) {
            if(target < nums[middle]) {
                end = middle - 1; 
                middle = (int) (start + end)/2; 
            } else { 
                start = middle + 1; 
                middle = (int) (start + end)/2; 
            }
        }

        if(nums[middle] == target) {
            return middle;
        } else {
            return -1; 
        }
         
    }
}


// Time Complexity:
// -> Flattening the 2D matrix into a 1D array: O(m * n) 
//    where m is the number of rows and n is the number of columns
// -> Performing binary search on the 1D array: O(log(m * n))
// Overall, O(m * n) + O(log(m * n))
// => O(m * n)
