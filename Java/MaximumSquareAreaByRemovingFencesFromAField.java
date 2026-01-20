//----------------------------PROBLEM 2975-------------------------------//
//         MAXIMUM SQUARE AREA BY REMOVING FENCES FROM A FIELD           //


// Logic:
// -> Set the MOD value for large number handling (1 x 10^9 + 7 as given in 
//    problem)
// -> Initialize two HashSets to store unique horizontal and vertical fence 
//    positions
// -> Add the boundary fences (1 and m for horizontal, 1 and n for vertical) 
//    to the respective sets
// -> Add all given horizontal fence positions to the horizontal set using 
//    a loop
// -> Add all given vertical fence positions to the vertical set using a loop
// -> Create a set to store all possible horizontal distances between fences
// -> Convert the horizontal set to an array for easier distance calculation
// -> Use nested loops to calculate all unique distances between horizontal
//    fences and store them in the horizontal distances set
// -> Create a set to store all possible vertical distances between fences
// -> Convert the vertical set to an array for easier distance calculation
// -> Use nested loops to calculate all unique distances between vertical
//    fences and store them in the vertical distances set
// -> Initialize a variable to track the maximum side length of the square
// -> Iterate through the horizontal distances set:
//    - For each distance, check if it exists in the vertical distances set
//    - If it does, update the maximum side length if this distance is larger
//      than the current maximum
// -> If no valid square side length is found (maxSide remains 0), return -1
// -> Otherwise, calculate the area of the largest square by squaring the
//    maximum side length and taking modulo MOD
// -> Return the calculated area as the result


class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        long MOD = 1_000_000_007;

        Set<Integer> hSet = new HashSet<>();
        Set<Integer> vSet = new HashSet<>();

        hSet.add(1);
        hSet.add(m);
        vSet.add(1);
        vSet.add(n);

        for (int x : hFences) {
             hSet.add(x);
        }

        for (int y : vFences) {
             vSet.add(y);
        }

        Set<Integer> hDistances = new HashSet<>();
        Integer[] hArr = hSet.toArray(new Integer[0]);

        for (int i = 0; i < hArr.length; i++) {
            for (int j = i + 1; j < hArr.length; j++) {
                hDistances.add(Math.abs(hArr[i] - hArr[j]));
            }
        }

        Set<Integer> vDistances = new HashSet<>();
        Integer[] vArr = vSet.toArray(new Integer[0]);

        for (int i = 0; i < vArr.length; i++) {
            for (int j = i + 1; j < vArr.length; j++) {
                vDistances.add(Math.abs(vArr[i] - vArr[j]));
            }
        }


        int maxSide = 0;
        for (int d : hDistances) {
            if (vDistances.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == 0) return -1;

        return (int) ((long) maxSide * maxSide % MOD);

    }
}


// Time Complexity: 
// - Caculating horizontal distances: O(H^2) where H is the number of 
//   unique horizontal fences
// - Calculating vertical distances: O(V^2) where V is the number of 
//   unique vertical fences
// - Finding maximum square side: O(D) where D is the number of unique 
//   distances
// Overall, O(H^2 + V^2 + D)
// => O(H^2 + V^2)

