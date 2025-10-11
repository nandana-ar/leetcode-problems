//-----------------------------PROBLEM 2---------------------------------//
//                          ADD TWO NUMBERS                              //


//Logic:
// -> Initialise a dummy head for the result linked list
// -> Use a pointer 'current' to track the end of the result list
// -> Use a variable 'remainder' to handle carry-over during addition
// -> Start the loop for both linked lists 
// -> For each node, get the value (or 0 if the node is null)
// -> Calculate the sum of the two values and the remainder
// -> Update the remainder for the next iteration (sum / 10)
// -> Create a new node with the digit value (sum % 10) and attach it to the 
//    result list
// -> Move the current pointer to the new node
// -> Move to the next nodes in both input lists if they exist
// -> After the loop, if there's any remaining carry, add a new node with 
//    that value
// -> Return the next node of the dummy head as the result (skipping the 
//    initial dummy 0)


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result; 
        int remainder = 0; 

        while(l1 != null || l2 != null) { 
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + remainder;
            remainder = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next; 
            
            if(l1 != null) { 
                l1 = l1.next; 
            }
            if(l2 !=null) { 
                l2 = l2.next; 
            }
        } 

        if (remainder > 0) {
            current.next = new ListNode(remainder);
        }

        return result.next; 
        
    }
}


//Time Complexity:
// -> Traversing both linked lists: O(max(m, n))
//   where m and n are the lengths of the two linked lists
// -> Assignment operations, if conditions, and arithmetic operations: O(1)
// Overall, O(max(m, n)) * O(1)
// => O(max(m, n))
