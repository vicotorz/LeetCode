
/**
 * leetcode-203
 * */
public class Remove_LinkedList_Elements {

    public ListNode removeElements(ListNode head, int val) {
        if(head==null) {
            return head;
        }


        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;

        ListNode pre = tmpHead;
        ListNode cur = head;


        while(cur!=null) {
            if(cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return tmpHead.next;
    }
}
