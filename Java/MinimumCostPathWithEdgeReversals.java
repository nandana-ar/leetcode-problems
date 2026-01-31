//------------------------------PROBLEM 3650-------------------------------//  
//                  MINIMUM COST PATH WITH EDGE REVERSALS                  //


// Logic:
// NOTE: This problem is a variation of Dijkstra's algorithm where we need 
//       to account for edge reversals with different costs
// -> Create an array where each element is a list of integer arrays to represent
//    all the edges going out from each node along with their costs
//    (adjacency list)
// -> Initialise the graph by adding an empty list for each node
// -> For each edge in the input edges array:
//    - Let x be the starting node, y be the ending node, and w be the cost
//    - Add the forward edge (x to y) with cost w to the adjacency list of x
//    - Add the reverse edge (y to x) with cost 2*w to the adjacency list of y
// (we double the cost for reversing the edge to account for the reversal cost
//  as per the problem statement)
// -> Create an array d to keep track of the minimum cost to reach each node
// -> Create a boolean array visited to keep track of visited nodes
// -> Initialize all distances in d to infinity, except for the starting node
//    (node 0) which is set to 0
// -> Create a priority queue for Dijkstra's algorithm
// -> Sort the priority queue based on the cost to reach each node using a comparator
// -> Add the starting node (0) with cost 0 to the priority queue
// -> While the priority queue is not empty:
//    - Poll the node with the smallest cost from the priority queue
//    - Let the current shortest distance to this node 
//    - If this node is the destination node (n-1), return the cost
//    - If this node has already been visited, skip and continue to the next iteration
//    - Mark this node as visited
//    - For each neighbor of the current node:
//       - Let y be the neighbor node and w be the cost to reach it
//       - If the cost to reach y through the current node is less than the
//         recorded cost in d[y], update d[y] and add y to the priority queue
// -> If the destination node is not reachable, return -1


class Solution {
    public int minCost(int n, int[][] edges) {
        
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int w = e[2];
            g[x].add(new int[] { y, w });
            g[y].add(new int[] { x, 2 * w });
        }

        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        pq.offer(new int[] { 0, 0 }); 

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dist = current[0];
            int x = current[1];

            if (x == n - 1) {
                return dist;
            }

            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            for (int[] neighbor : g[x]) {
                int y = neighbor[0];
                int w = neighbor[1];

                if (dist + w < d[y]) {
                    d[y] = dist + w;
                    pq.offer(new int[] { d[y], y });
                }
            }
        }

        return -1;
    }
}


// Time Complexity:
// -> Building the graph: O(E) where E is the number of edges
// -> Dijkstra's algorithm using a priority queue: O((V + E) log V)
// Overall, O(E + (V + E) log V)
// => O((V + E) log V)