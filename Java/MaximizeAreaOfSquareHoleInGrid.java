//----------------------------PROBLEM 2943-------------------------------//
//                MAXIMIZE AREA OF SQUARE HOLE IN GRID                   //


// Logic:
// -> Initialise variables to track maximum horizontal and vertical gaps
// -> Use two HashSets to store unique horizontal and vertical bar positions
// -> Iterate through horizontal bar positions:
//    - For each bar position, check if the previous position is not in the set
//    - If not, start counting the length of the gap by moving forward
//      until the next position is not in the set
//    - Update the maximum horizontal gap found
// -> Iterate through vertical bar positions:
//    - For each bar position, check if the previous position is not in the set
//    - If not, start counting the length of the gap by moving forward
//      until the next position is not in the set
//    - Update the maximum vertical gap found
// -> Set the maximum square length as the minimum of the two maximum gaps
//    found by the iterations plus one
// -> Return the area of the largest square hole by squaring the maximum
//    square length


class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        int maxSquareLength = 0; 
        int maxH = 0; 
        int maxV = 0; 

        Set<Integer> hSet = new HashSet<>();
        for (int x : hBars) {
             hSet.add(x);
        }

        Set<Integer> vSet = new HashSet<>();
        for (int y : vBars) {
             vSet.add(y);
        }

        for(int h : hSet) {
            if(!hSet.contains(h-1)) {
                int current = h;
                int length = 1;

                while(hSet.contains(current + 1)) {
                    current+=1; 
                    length+=1; 
                }

                maxH = Math.max(maxH, length);
            }
        }

        for(int v : vSet) {
            if(!vSet.contains(v-1)) {
                int current = v;
                int length = 1;

                while(vSet.contains(current + 1)) {
                    current+=1; 
                    length+=1; 
                }

                maxV = Math.max(maxV, length);
            }  
        }

        maxSquareLength = Math.min(maxH +1, maxV + 1);

        return maxSquareLength * maxSquareLength; 
    }
}



