package com.improve.programming.medium;

public class removeNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode start = head;
        ListNode end = head;
        while(n > 1 && end != null) {
            end = end.next;
            n--;
        }
        while(end != null) {
            prev = start;
            start = start.next;
            end = end.next;
        }
        if(prev == null) {

        }
        return head;
    }

}

class ListNode {
 int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
