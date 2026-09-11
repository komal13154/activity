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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = null;
        int size = 0;
        ListNode curr = head;

        // Find length and tail
        while (curr != null) {
            tail = curr;
            curr = curr.next;
            size++;
        }

        // Avoid unnecessary rotations
        int newK = k % size;

        if (newK == 0) {
            return head;
        }

        int diff = size - newK;

        // Reset curr to head
        curr = head;

        // Find new tail
        int i = 0;
        while (i < diff - 1) {
            curr = curr.next;
            i++;
        }

        // New head will be next of new tail
        ListNode newHead = curr.next;

        // Break the list
        curr.next = null;

        // Connect old tail to old head
        tail.next = head;

        return newHead;
    }
}