//------------------------------PROBLEM 19-------------------------------//
//                    REMOVE NTH NODE FROM END OF LIST                   //


// Logic:
// -> Calculate the total length of the linked list by traversing
// -> Determine the index of the node to be removed from the start of the list
//    by subtracting n from the total length
// -> If the node to be removed is the head (index 0), return head.next
// -> Otherwise, traverse the list again to find the node just before the one to
//    be removed
// -> Update the next pointer of this node to skip the node to be removed
// -> Return the head of the modified list


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0; 
        ListNode current = head; 

        while(current != null) { 
            length++; 
            current = current.next; 
        }

        int removeIndex = length - n; 
        if(removeIndex == 0) {
            return head.next; 
        }

        current = head; 
        for(int i = 0; i < length - 1; i++) {
            if((i + 1) == removeIndex) {
                current.next = current.next.next; 
                break; 
            }
            current = current.next; 
        }

        return head; 

    }
}


// Time Complexity:
// -> Calculating the length of the list: O(n)
// -> Traversing to the node before the one to be removed: O(n)
// -> Assignment operations and pointer updates: O(1)
// Overall, O(n) * O(1) + O(n) * O(1)
// => O(n)
