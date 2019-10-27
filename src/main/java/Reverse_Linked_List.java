/**
 * LeetCode-206
 * 递归，再想想
 */
public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
