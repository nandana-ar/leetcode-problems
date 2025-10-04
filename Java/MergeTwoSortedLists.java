//-----------------------------PROBLEM 21--------------------------------//
//                       MERGE TWO SORTED LISTS                          //


//Logic:
// -> Create a dummy node to serve as the starting point of the merged list
// -> Use a pointer (current) to track the end of the merged list
// -> While both input lists are not empty:
//    - Compare the values of the current nodes of both lists
//    - Append the smaller value node to the merged list
//    - Move the pointer of the list from which the node was taken to the 
//      next node
//    - Move the current pointer of the merged list to the newly added node
// -> If one of the lists is empty, append the remaining nodes of the non-empty 
//    list to the merged list
// -> Return the merged list, which starts from the next node of the dummy node


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

//Time Complexity:
// -> Each node from both lists is processed exactly once: O(n + m)
// where n and m are the lengths of list1 and list2 respectively
// -> Assignment operations and pointer updates: O(1)
// Overall, O(n + m) * O(1)
// => O(n + m)