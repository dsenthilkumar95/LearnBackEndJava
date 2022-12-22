package com.improve.programming.easy;

import com.improve.programming.medium.ListNode;

public class RemoveDupSortedLinkedListLeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)  return null;
        ListNode prev = head;
        ListNode ref = head.next;
        while(ref != null) {
            if(prev.val == ref.val) {
                prev.next = ref.next;
                ref = ref.next;
            } else {
                prev = ref;
                ref = ref.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDupSortedLinkedListLeetCode83 removeDupSortedLinkedListLeetCode83 = new RemoveDupSortedLinkedListLeetCode83();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;
        removeDupSortedLinkedListLeetCode83.deleteDuplicates(head);
    }
}