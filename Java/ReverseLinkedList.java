//------------------------------PROBLEM 206------------------------------//
//                          REVERSE LINKED LIST                          //


// Logic:
// -> Initialise three pointers: 
//    - current (to traverse the list)
//    - previous (to keep track of the reversed part)
//    - next (to temporarily store the next node)
// -> Iterate through the linked list:
//    - Store the next node
//    - Reverse the current node's pointer to point to the previous node
//    - Move the previous and current pointers one step forward
// -> At the end, previous will point to the new head of the reversed list
// -> Return previous as the new head of the reversed linked list


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
    public ListNode reverseList(ListNode head) {

        ListNode current = head; 
        ListNode previous = null; 
        ListNode next; 

        while(current != null) {
            next = current.next; 
            current.next = previous; 
            previous = current; 
            current = next; 
        }

        return previous; 
    }
}


// Time Complexity: 
// -> Traversing the entire list once: O(n)
// -> Each operation inside the loop is O(1)
// Overall, O(n) * O(1)
// => O(n)