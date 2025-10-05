//------------------------------PROBLEM 141------------------------------//
//                           LINKED LIST CYCLE                           //


// Logic:
// -> Use two pointers (current and next) to traverse the linked list
//    Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
// -> Move the 'current' pointer one step at a time
// -> Move the 'next' pointer two steps at a time
// -> If there is a cycle, the two pointers will eventually meet
// -> If the 'next' pointer reaches the end of the list (null), there is no cycle
// -> Return true if a cycle is detected, otherwise return false


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 
import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) 
            return false;

        ListNode current  = head;
        ListNode next  = head.next;

        while (current != next) {
            if (next == null || next.next == null) 
                return false;

            current = current.next;
            next = next.next.next;
        }

        return true; 
    }

}


// Time Complexity:
// -> Each pointer traverses the list at most once: O(n)
// -> Assignment operations and pointer updates: O(1)
// Overall, O(n) * O(1)
// => O(n)