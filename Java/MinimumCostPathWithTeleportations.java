//------------------------------PROBLEM 3651-------------------------------//  
//                  MINIMUM COST PATH WITH TELEPORTATIONS                  //


// Logic:
// NOTE: This problem is a variation of Dijkstra's algorithm where we need
//       to account for teleportations with different costs
// A teleportation allows us to move from any cell to any other cell with the 
// same value at a cost of 0
// -> Create a list of arrays to represent all the points in the grid along with
//    their values
// -> Add all the points in the grid to the list along with their values
// -> Sort the list based on the values of the points in ascending order using 
//    a comparator
// -> Create a 2D array costs to keep track of the minimum cost to reach each
//    cell in the grid
// -> Initialize all costs in the costs array to infinity
// -> For each teleportation from 0 to k (where k is the maximum number of 
//    teleportations allowed):
//    - Initialize a variable minCost to keep track of the minimum cost to reach
//      any cell in the grid
//    - For each point in the sorted list of points:
//       - Update minCost to be the minimum of minCost and the cost to reach
//         the current point from the costs array
//       - If the next point in the sorted list has the same value as the current
//         point, continue to the next iteration (since we can teleport between
//         points with the same value at a cost of 0)
//       - For all points with the same value, update their costs in the costs
//         array to be the minimum of their current cost and minCost (since we
//         can teleport to these points at a cost of 0)
//    - After processing all points with the same value, update the costs array
//      by iterating through the grid in reverse order (from bottom-right to
//      top-left) and updating the cost to reach each cell based on the cost to
//      reach its right and down neighbors (since we can only move right or down
//      in the grid)
// -> Finally, return the cost to reach the top-left cell (0, 0) from the costs
//    array, which will be the minimum cost to reach the destination cell (m-1,
//    n-1) from the starting cell (0, 0) with at most k teleportations
// -> If the cost to reach the destination cell is still infinity, return -1
//    to indicate that it is not possible to reach the destination cell with the
//    given constraints


class Solution {

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                points.add(new int[] { i, j });
            }
        }

        points.sort(Comparator.comparingInt(p -> grid[p[0]][p[1]]));
        int[][] costs = new int[m][n];

        for (int[] row : costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int t = 0; t <= k; t++) {
            int minCost = Integer.MAX_VALUE;

            for (int i = 0, j = 0; i < points.size(); i++) {
                minCost = Math.min(
                    minCost,
                    costs[points.get(i)[0]][points.get(i)[1]]
                );
                if (
                    i + 1 < points.size() &&
                    grid[points.get(i)[0]][points.get(i)[1]] ==
                    grid[points.get(i + 1)[0]][points.get(i + 1)[1]]
                ) {
                    continue;
                }

                for (int r = j; r <= i; r++) {
                    costs[points.get(r)[0]][points.get(r)[1]] = minCost;
                }

                j = i + 1;

            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        costs[i][j] = 0;
                        continue;
                    }
                    if (i != m - 1) {
                        costs[i][j] = Math.min(
                            costs[i][j],
                            costs[i + 1][j] + grid[i + 1][j]
                        );
                    }
                    if (j != n - 1) {
                        costs[i][j] = Math.min(
                            costs[i][j],
                            costs[i][j + 1] + grid[i][j + 1]
                        );
                    }
                }
            }
        }

        return costs[0][0];

    }
    
}

// Time Complexity: 
// -> Sorting the points: O(m*n log(m*n))
// -> Updating costs for teleportations: O(k * m * n) since we iterate through
//    the points list k times and update costs for each point
// -> Updating costs for right and down movements: O(k * m * n) since we iterate
//    through the grid k times and update costs for each cell
// Overall, O(m*n log(m*n)) + O() k * m * n)
//=> O(m*n log(m*n) + k * m * n)