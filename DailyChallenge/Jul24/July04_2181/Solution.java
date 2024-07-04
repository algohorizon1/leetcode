
// Time Complexity: O(n)
// Space Complexity: O(1)

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
class Solution {
    public ListNode mergeNodes(ListNode head) {
        // Initialize a pointer to traverse the list starting from the node after the initial zero
        ListNode curr = head.next;
        // Initialize a tail pointer to construct the new list
        ListNode tail = curr;

        // Traverse the entire list
        while(curr != null) {
            int sum = 0;
            // Sum up values until the next zero is encountered
            while(curr.val != 0) {
                sum += curr.val;
                curr = curr.next;
            }
            // Move curr to the next node after the zero
            curr = curr.next;
            // Assign the sum to the current tail node
            tail.val = sum;
            // Update the next pointer of tail to skip over the zero
            tail.next = curr;
            // Move the tail pointer to the next node
            tail = curr;
        }
        // Return the modified list starting from the node after the initial zero
        return head.next;
    }
}