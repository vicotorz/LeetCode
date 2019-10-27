/**
 * LeetCode-234
 */
public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode mid = findMid(head);//获得中间节点
        ListNode second = mid.next;
        mid.next = null;
        ListNode first = head;
        second = reverse(second);//将从中间节点的链表反转
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
