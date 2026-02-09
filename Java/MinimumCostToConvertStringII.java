//------------------------------PROBLEM 2977-------------------------------//  
//                    MINIMUM COST TO CONVERT STRING II                    //


// Logic:
// NOTE: This problem can be solved using dynamic programming and the 
// Floyd-Warshall algorithm
// -> Set a large value (infinity) to represent the cost of transforming one 
//    string
// -> Create a hash map
//    - Assign a unique index to each string in the original array
//    - Assign a unique index to each string in the changed array (if not 
//      already assigned)
// -> Create a 2D array distance to store the minimum cost to transform one
//    string to another string
// -> Initialize the distance array such that:
//    - distance[i][i] = 0 for all strings (since transforming a string to 
//      itself has no cost)
//    - all the other entries are set to infinity
// -> For each transformation given in the input:
//    - Get the indices of the original and changed strings (u and v) from the
//      hash map
//    - Update distance[u][v] to be the minimum of its current value and the
//      cost of the transformation (cost[i])
// -> Use the Floyd-Warshall algorithm to compute the shortest path between
//    all pairs of strings:
//    - For each intermediate string k from 0 to m-1:
//       - For each source string i from 0 to m-1:
//          - For each destination string j from 0 to m-1:
//             - If the path from i to k and from k to j is valid (i.e., not
//               infinity) and the total cost of this path is less than the
//               current distance from i to j, update distance[i][j] to be the
//               total cost
// -> After computing the shortest paths, use dynamic programming to calculate
//    the minimum cost to convert the source string to the target string:
//    - Create a dp array of size n+1, where dp[i] represents the minimum cost
//      to convert the substring of source starting from index i to the
//      corresponding substring of target
//    - Initialize dp[n] to 0 (since converting an empty substring has no cost)
//    - For each index i from n-1 down to 0:    
//       - If the character at index i in source is the same as the character at
//         index i in target, set dp[i] to dp[i+1] (since no transformation is needed)
//       - Otherwise, for each string s in the hash map:
//          - If the substring of source starting at index i does not start with s,
//            continue to the next string
//          - Let t be the corresponding substring of target that has the same
//            length as s
//          - If t is not in the hash map, continue to the next string
//          - Get the indices of s and t from the hash map (u and v)
//          - If distance[u][v] is infinity, it means that it is not possible
//            to transform s to t, so continue to the next string
//          - Otherwise, update dp[i] to be the minimum of its current value and
//            the total cost of transforming s to t plus dp[i+len(s)]
// -> Finally, return dp[0] as the minimum cost to convert the source string
//    to the target string (or -1 if it is not possible to do so with the given transformations)


class Solution {
    
    static final long INF = Long.MAX_VALUE / 4;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        
        int n = source.length();

        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String s : original) {
            if (!id.containsKey(s)) id.put(s, idx++);
        }
        for (String s : changed) {
            if (!id.containsKey(s)) id.put(s, idx++);
        }

        int m = id.size();
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            for (String s : id.keySet()) {
                int len = s.length();
                if (i + len > n) continue;

                if (!source.startsWith(s, i)) continue;

                String t = target.substring(i, i + len);
                if (!id.containsKey(t)) continue;

                int u = id.get(s);
                int v = id.get(t);

                if (dist[u][v] == INF) continue;

                dp[i] = Math.min(dp[i], dist[u][v] + dp[i + len]);
            }
        }

        return dp[0] >= INF ? -1 : dp[0];
    }
}


// Time Complexity:
// -> Creating hash map and initializing distance array: O(m)
// where m is the number of unique strings in original and changed arrays
// -> Floyd-Warshall algorithm: O(m^3)
// -> Dynamic programming to calculate minimum cost: O(n * m)
// where n is the length of the source string and m is the number of unique 
//                                   strings in original and changed arrays
// Overall, O(m) + O(m^3) + O(n * m) 
// => O(m^3 + n * m)