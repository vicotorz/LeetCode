
/**
 * leetcode-86
 * */
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode lessHead = new ListNode(-1);
        ListNode moreHead = new ListNode(-1);

        ListNode lessNode = lessHead;
        ListNode moreNode = moreHead;
        ListNode curNode = head;

        while (curNode != null) {
            if (curNode.val < x) {
                lessNode.next = new ListNode(curNode.val);
                lessNode = lessNode.next;
            } else {
                moreNode.next = new ListNode(curNode.val);
                moreNode = moreNode.next;
            }
            curNode = curNode.next;
        }

        lessNode.next = moreHead.next;

        return lessHead.next;
    }
}
