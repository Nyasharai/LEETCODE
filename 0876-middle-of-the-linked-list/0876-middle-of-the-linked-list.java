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
    public ListNode middleNode(ListNode head) {
        // Initialize length of the linked list
        int len = 1;
        // Pointer to traverse the list
        ListNode index = head;
        // Traverse the list to find its length
        while (index.next != null) {
            index = index.next;
            len++;
        }
        // Calculate the index of the middle node
        len = len / 2;
        // Traverse to the middle node
        for (int i = 1; i <= len; i++) {
            head = head.next;
        }
        // Return the middle node
        return head; 
    }
}