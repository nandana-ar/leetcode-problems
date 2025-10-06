//------------------------------PROBLEM 143------------------------------//
//                             REORDER LIST                              //


// Logic:
// -> If the list is empty or has only one node, return 
// -> Use two pointers (current and next) to traverse the linked list 
//    where the fast pointer moves two steps at a time and the slow pointer 
//    moves one step at a time
// -> When the fast pointer reaches the end, the slow pointer will be at the 
//    middle
// -> Reverse the second half of the list starting from the node after the 
//    slow pointer
// -> Merge the two halves by alternating nodes from each half starting from 
//    the head of the list and the head of the reversed second half
// -> Continue until all nodes from the second half are merged


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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) { 
            return; 
        }

        ListNode slow = head; 
        ListNode fast = head.next; 
        

        while(fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode next; 
        ListNode current = slow.next; 
        slow.next = null; 
        ListNode previous = null; 

        while(current != null) {
            next = current.next; 
            current.next = previous; 
            previous = current; 
            current = next; 
        }

        ListNode first = head; 
        ListNode second = previous;
        
        while (second != null) {
            ListNode temp1 = first.next; 
            ListNode temp2 = second.next; 
            first.next = second; 
            second.next = temp1; 
            first = temp1; 
            second = temp2; 
        }
    
    }
}


// Time Complexity:
// -> Finding the middle of the list: O(n)
// -> Reversing the second half of the list: O(n)
// -> Merging the two halves: O(n)
// -> Assignment operations and pointer updates: O(1)
// Overall, O(n) * O(1) + O(n) * O(1) + O(n) * O(1) 
// => O(n)