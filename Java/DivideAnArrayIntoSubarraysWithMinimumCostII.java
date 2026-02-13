//------------------------------PROBLEM 3013-------------------------------//  
//            DIVIDE AN ARRAY INTO SUBARRAYS WITH MINIMUM COST II          //

// Logic: 
// -> Create a Container class 
// -> Attributes of the Container class:
//    - k: the number of smallest elements to maintain
//    - st1: a TreeMap to store the k smallest elements in the current window
//    - st2: a TreeMap to store the remaining elements in the current window
//    - sm: the sum of the k smallest elements in st1
// -> Methods of the Container class:
//    - removeOne: 
//      - Get the count of the key in the map
//      - If the count is 1, remove the key from the map
//      - Otherwise, decrement the count of the key in the map
//    - addOne:
//      - Increment the count of the key in the map
//    - adjust:
//      - While st1 has less than k elements and st2 is not empty, get the 
//       smallest element from st2, add it to st1, update the sum, and 
//       remove it from st2
//      - While st1 has more than k elements, get the largest element from st1,
//       add it to st2, update the sum, and remove it from st1
//    - add:
//      - If the new element is greater than or equal to the smallest element 
//        in st2, add it to st2
//      - Otherwise, add it to st1 and update the sum
//      - Call adjust to maintain the balance between st1 and st2
//    - erase:
//      - If the element to be removed is in st1, remove it from st1
//        and update the sum
//      - If the element to be removed is in st2, remove it from st2
//      - Call adjust to maintain the balance between st1 and st2
//    - sum:
//      - Return the sum of the k smallest elements in st1
// -> Main function minimumCost:
//    - Initialize a Container object with k - 2
//    - Add the first k - 2 elements of the array to the Container
//    - Initialize the answer with the sum of the k - 2 smallest elements and
//      the k - 1-th element
//    - Iterate through the array starting from the k-th element:
//      - Calculate the index j of the element that is dist + 1 positions before
//      - If j is greater than 0, erase the element at index j from the Container
//      - Add the element at index i - 1 to the Container
//      - Update the answer with the minimum of the current answer and the sum
//        of the k - 2 smallest elements plus the current element at index i
//    - Return the final answer plus the first element of the array


class Container {

    private int k;
    private int st1Size;
    private int st2Size;
    private TreeMap<Integer, Integer> st1;
    private TreeMap<Integer, Integer> st2;
    private long sm;

    public Container(int k) {
        this.k = k;
        this.st1 = new TreeMap<>();
        this.st2 = new TreeMap<>();
        this.sm = 0;
        this.st1Size = 0;
        this.st2Size = 0;
    }

    private void removeOne(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }

    private void addOne(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private void adjust() {
        while (st1Size < k && !st2.isEmpty()) {
            int x = st2.firstKey();
            addOne(st1, x);
            st1Size++;
            sm += x;
            removeOne(st2, x);
            st2Size--;
        }
        while (st1Size > k) {
            int x = st1.lastKey();
            addOne(st2, x);
            st2Size++;
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        }
    }

    public void add(int x) {
        if (!st2.isEmpty() && x >= st2.firstKey()) {
            addOne(st2, x);
            st2Size++;
        } else {
            addOne(st1, x);
            st1Size++;
            sm += x;
        }
        adjust();
    }

    public void erase(int x) {
        if (st1.containsKey(x)) {
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        } else if (st2.containsKey(x)) {
            removeOne(st2, x);
            st2Size--;
        }
        adjust();
    }

    public long sum() {
        return sm;
    }
}

class Solution {

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        Container cnt = new Container(k - 2);
        for (int i = 1; i < k - 1; i++) {
            cnt.add(nums[i]);
        }

        long ans = cnt.sum() + nums[k - 1];
        for (int i = k; i < n; i++) {
            int j = i - dist - 1;
            if (j > 0) {
                cnt.erase(nums[j]);
            }
            cnt.add(nums[i - 1]);
            ans = Math.min(ans, cnt.sum() + nums[i]);
        }

        return ans + nums[0];
    }
}


// Time Complexity:
// -> Iterating through the array: O(n)
// -> Add and erase operations in the Container class: O(log k) 
//    (because of TreeMap)
// -> Adjust operation in the Container class: O(k log k) in the worst case
// Overall, O(n) * O(log k) + O(n) * O(k log k)
// => O(n k log k)