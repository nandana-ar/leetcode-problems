//------------------------------PROBLEM 853------------------------------//
//                               CAR FLEET                               //


// Logic: 
// -> Create a two dimensional array to store 
//    - the position for each car given in the position array
//    - the time taken to reach the target for each car found using the 
//      formula: time = (target - position) / speed
// -> Sort the cars array in descending order based on the position of the 
//    cars
// -> Iterate through the sorted cars array
// -> For each car, check if its time to reach the target is greater than 
//    the current maximum time
//    - If it is, it means this car cannot catch up to the fleet ahead, so 
//      increment the fleet count and update the current maximum time
// -> Return the fleet count


import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length; 
        if (n == 0)
            return 0; 
        
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; 
            cars[i][1] = (double)(target - position[i]) / speed[i]; 
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleetCount = 0; 
        double currTime = 0;

        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (time > currTime) {
                fleetCount++;
                currTime = time; 
            }
        }

        return fleetCount; 
        
    }
}


// Time Complexity:
// -> Creating the cars array: O(n)
// -> Sorting the cars array based on position: O(n log n)
// -> Iterating through the cars array: O(n)
// Overall, O(n) + O(n log n) + O(n)
// => O(n log n)