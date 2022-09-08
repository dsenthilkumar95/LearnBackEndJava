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
        while(end.next != null) {
            prev = start;
            start = start.next;
            end = end.next;
        }
        if(prev == null) {
            head = head.next;
        } else {
            prev.next = start.next;
        }
        return head;
    }

//    Efficient solution is move till n nodes from start, if its end return head.next, else more one more step and
//    iterate till the end, then remove keep start.next = start.next.next and return head

    public ListNode removeNthFromEndEfficientSubmissions(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int count = 0;
        while(dummy != null && dummy.next != null) {
            count++;
            dummy = dummy.next;
        }
        int num = count - n;

        ListNode dummy2 = new ListNode();
        dummy2.next = head;
        ListNode p = dummy2;

        int curr = 0;
        while(p != null && p.next != null && curr<num) {
            p = p.next;
            curr++;
        }
        p.next = p.next.next;
        return dummy2.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
