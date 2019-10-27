/**
 * LeetCode-148
 *  基于两表合并
 *  hard for me
 */
public class Sort_List {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//断开，分成两个链表
        //head----> prev   slow----> end
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode result =merge(l1, l2);//head,slow之间排序
        return result;
    }


    //给定范围合并两个链表
    public ListNode merge(ListNode l1,ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode tmp = resHead;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                tmp.next = l1;
                l1=l1.next;
            }else {
                tmp.next =l2;
                l2=l2.next;
            }
            tmp=tmp.next;
        }
        if(l1!=null) {
            tmp.next=l1;
        }
        if(l2!=null) {
            tmp.next=l2;
        }
        return resHead.next;
    }
}
