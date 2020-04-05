/**
 * LeetCode-83
 */

public class Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curNode = head;
        int checkVal = head.val;

        ListNode tmpHead = new ListNode(checkVal);
        ListNode tmpCur = tmpHead;

        while (curNode.next != null) {
            if (checkVal != curNode.val) {
                tmpCur.next = new ListNode(curNode.val);
                checkVal = curNode.val;
                tmpCur = tmpCur.next;
            }
            curNode = curNode.next;
        }

        if (checkVal != curNode.val) {
            tmpCur.next = new ListNode(curNode.val);
        }
        return tmpHead;
    }
}
