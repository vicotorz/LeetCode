/**
 * leetcode-328
 * */
public class OddEven_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        //printList(head);

        // 考虑三个节点以上的链表
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;

        ListNode cur = head;
        ListNode nxt = cur.next;

        boolean isOdd = true;
        while (cur != null) {

            cur.next = null;
            // System.out.println(cur.val);
            if (isOdd) {
                oddCur.next = cur;
                oddCur = oddCur.next;
                isOdd = false;
            } else {
                evenCur.next = cur;
                evenCur = evenCur.next;
                isOdd = true;
            }
            // System.out.println(nxt.val);
            cur = nxt;
            if (cur != null) {
                nxt = cur.next;
            }
        }

        oddCur.next = evenHead.next;

        return oddHead.next;
    }
}
