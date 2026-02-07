//------------------------------PROBLEM 2976-------------------------------//  
//                     MINIMUM COST TO CONVERT STRING I                    //


// Logic:
// NOTE: This problem can be solved using the Floyd-Warshall algorithm to find
//       the shortest path between characters in the transformation graph
// -> Assign a large value (infinity) to represent the cost of transforming 
//    one character
// -> Create a 2D array distance to store the minimum cost to transform one
//    character to another character
// -> Initialize the distance array such that distance[i][i] = 0 for all
//    characters (since transforming a character to itself has no cost)
// -> For each transformation given in the input:
//    - Set u to the index of the original character (original[i] - 'a')
//    - Set v to the index of the changed character (changed[i] - 'a')
//    - Update distance[u][v] to be the minimum of its current value and the
//      cost of the transformation (cost[i])
// -> Use the Floyd-Warshall algorithm to compute the shortest path between
//    all pairs of characters:
//    - For each intermediate character k from 0 to 25:
//       - For each source character i from 0 to 25:
//          - For each destination character j from 0 to 25:
//             - If the path from i to k and from k to j is valid (i.e., not
//               infinity) and the total cost of this path is less than the 
//               current distance from i to j, update distance[i][j] to be 
//               the total cost
// -> After computing the shortest paths, calculate the total cost to convert
//    the source string to the target string:
//    - Initialize totalCost to 0
//    - For each character in the source string:
//       - If the character is the same as the corresponding character in the
//         target string, continue to the next character (since no transformation
//         is needed)
//       - Otherwise, get the indices of the source and target characters (u and v)
//       - If distance[u][v] is still infinity, it means that it is not possible
//         to transform the source character to the target character, so return -1
//       - Otherwise, add distance[u][v] to totalCost
// -> Finally, return totalCost as the minimum cost to convert the source string
//    to the target string (or -1 if it is not possible to do so with the given 
//    transformations)


class Solution {

    public static final long INF = Long.MAX_VALUE; 
    public long minimumCost(String source, String target, char[] original, 
                            char[] changed, int[] cost) {

        long[][] distance = new long[26][26];

        for (long[] row : distance) {
            Arrays.fill(row, INF);
        }

        for(int i = 0; i < 26; i++) {
            distance[i][i] = 0; 
        }

        for(int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            distance[u][v] = Math.min(distance[u][v], cost[i]);
        }

        for(int k = 0; k < 26; k++) {
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 26; j++) {

                    if( (distance[i][k] != INF && distance[k][j] != INF) && 
                        (distance[i][k] + distance[k][j] < distance[i][j])  ) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }    
                    
                }
            }
        }

        long totalCost = 0; 

        for(int i = 0; i < source.length(); i++) {
            if(source.charAt(i) == target.charAt(i)) {
                continue; 
            }

            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a'; 

            if(distance[u][v] == INF) {
                return -1; 
            }

            totalCost += distance[u][v];
        }

        return totalCost; 
        
    }
}


// Time Complexity:
// -> Initializing the distance array: O(26^2) = O(1)
// -> Processing the transformations: O(m) where m is the number of transformations
// -> Floyd-Warshall algorithm: O(26^3) = O(1)
// -> Calculating the total cost: O(n) where n is the length of the source string
// Overall, O(1) + O(m) + O(1) + O(n) = O(m + n)
// => O(m + n) where m is the number of transformations and n is the length of the source string