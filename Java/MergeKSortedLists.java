//------------------------------PROBLEM 23 ------------------------------//
//                         MERGE K SORTED LISTS                          //


// Logic:
// -> Find the length of the lists array
// -> If the length is 0, return null
// -> Initialize a count variable to 1 and set current to the first list
// -> While count is less than the length of the lists array, merge the 
//    current list with the next list using the Merge Two Sorted Lists as 
//    a helper function
// -> Increment the count
// -> Continue this process until all lists are merged
// -> Return the merged list when count equals the length of the lists array


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length == 0) {
            return null; 
        }
        
        int count = 1; 
        ListNode current = lists[0];
        while (count < length) {
            current = mergeTwoLists(current, lists[count]);
            count++; 
        }

        return current; 
        
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next; 
    }
}

// Time Complexity:
// -> Merging two lists: O(n + m) 
//   where n and m are the lengths of the two lists being merged
// -> Average Case - Merging k lists involves k-1 merge operations
//    - If each list has an average length of N/k (where N is the total 
//      number of nodes across all lists), then each merge operation takes
//      O(N/k + N/k) = O(2N/k) => O(N/k)
//    - So total complexity = 
//      O((k-1) * (N/k)) = O(N * (k-1)/k) => O(N)
// -> Worst Case - Merging k lists where each list has length N
//    - Each merge operation takes O(N + N) = O(2N) => O(N)
//    - So total complexity = 
//      O((k-1) * N) => O(k * N)