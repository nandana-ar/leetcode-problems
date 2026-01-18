//----------------------------PROBLEM 3454-------------------------------//
//                        SEPARATE SQUARES II                            //


// Logic:
// -> The goal is to find a horizontal line that splits the total union 
//    area of multiple squares into two equal halves
// -> Since squares can overlap, the area must be calculated using a 
//    sweep line approach combined with a segment tree
// -> The solution sweeps vertically along the y-axis while dynamically 
//    tracking horizontal coverage
// -> SegmentTree class:
//    - Used to keep track of how much horizontal space (x-direction)
//      is currently covered by the squares
//    - The x-coordinates are split into small segments using all square
//      boundaries so that coverage can be tracked accurately
//    - Each segment stores how many squares are covering it
//    - If at least one square covers a segment, the whole segment is counted
//      as covered
//    - If no square covers a segment, its covered length is taken from
//      its child segments
//    - When a square starts or ends, the segment tree updates the
//      corresponding x-interval
//    - The tree can quickly return the total covered x-length at any time
//
// -> Solution class:
//    - separateSquares function:
//       - Each square is converted into two events:
//           * one when the square starts (bottom edge)
//           * one when the square ends (top edge)
//       - All events are sorted by their y-coordinate
//       - A sweep line moves upward through the events in order
//       - At each step, the segment tree stores which x-intervals are active
//       - The area between two consecutive y-levels is calculated using:
//           covered width × vertical distance
//       - This area is added to a running total
//       - The area after each step is saved so it can be searched later
//       - The total area is divided by two to find the target split area
//       - A binary search is used to find where this target area is reached
//       - The final y-value is calculated by finding how far into the
//         current strip the split occurs
//    - binarySearch function:
//       - Searches through the saved area values
//       - Finds the point where the accumulated area first reaches
//         half of the total area
//       - Helps identify the exact vertical strip where the split line lies


class SegmentTree {

    private int[] count;
    private int[] covered;
    private int[] xs;
    private int n;

    public SegmentTree(int[] xs_) {
        xs = xs_;
        n = xs.length - 1;
        count = new int[4 * n];
        covered = new int[4 * n];
    }

    private void modify(
        int qleft,
        int qright,
        int qval,
        int left,
        int right,
        int pos
    ) {
        if (xs[right + 1] <= qleft || xs[left] >= qright) {
            return;
        }
        if (qleft <= xs[left] && xs[right + 1] <= qright) {
            count[pos] += qval;
        } else {
            int mid = (left + right) / 2;
            modify(qleft, qright, qval, left, mid, pos * 2 + 1);
            modify(qleft, qright, qval, mid + 1, right, pos * 2 + 2);
        }

        if (count[pos] > 0) {
            covered[pos] = xs[right + 1] - xs[left];
        } else {
            if (left == right) {
                covered[pos] = 0;
            } else {
                covered[pos] = covered[pos * 2 + 1] + covered[pos * 2 + 2];
            }
        }
    }

    public void update(int qleft, int qright, int qval) {
        modify(qleft, qright, qval, 0, n - 1, 0);
    }

    public int query() {
        return covered[0];
    }
}

class Solution {

    public double separateSquares(int[][] squares) {
        // save events: (y-coordinate, type, left boundary, right boundary)
        List<int[]> events = new ArrayList<>();
        Set<Integer> xsSet = new TreeSet<>();

        for (int[] sq : squares) {
            int x = sq[0];
            int y = sq[1];
            int l = sq[2];
            int xr = x + l;
            events.add(new int[] { y, 1, x, xr });
            events.add(new int[] { y + l, -1, x, xr });
            xsSet.add(x);
            xsSet.add(xr);
        }

        // sort events by y-coordinate
        events.sort((a, b) -> Integer.compare(a[0], b[0]));
        // discrete coordinates
        int[] xs = xsSet.stream().mapToInt(i -> i).toArray();
        // initialize the segment tree
        SegmentTree segTree = new SegmentTree(xs);

        List<Long> psum = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();
        Long totalArea = 0L;
        int prev = events.get(0)[0];

        // scan: calculate total area and record intermediate states
        for (int[] event : events) {
            int y = event[0];
            int delta = event[1];
            int xl = event[2];
            int xr = event[3];
            int len = segTree.query();
            totalArea += (long) len * (y - prev);
            segTree.update(xl, xr, delta);
            // record prefix sums and widths
            psum.add(totalArea);
            widths.add(segTree.query());
            prev = y;
        }

        // calculate the target area (half rounded up)
        long target = (long) (totalArea + 1) / 2;
        // binary search
        int i = binarySearch(psum, target);
        double area = psum.get(i);
        // get the corresponding area, width, and height
        int width = widths.get(i);
        int height = events.get(i)[0];

        return height + (totalArea - area * 2) / (width * 2.0);
    }

    private int binarySearch(List<Long> list, long target) {
        int left = 0;
        int right = list.size() - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}