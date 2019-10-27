/**
 * LeetCode-19
 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //注意删头和尾元素(用只有两个节点的链表)
        //在head前加一个节点
        //tailNode=null的时候删除，如果delete仍在新加的节点上，删除头
        if(n==0) {
            return head;
        }
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next=head;
        ListNode deleteNode= tmpHead;
        ListNode tailNode= head;


        for(int i=1;i<=n&&tailNode!=null;i++) {
            tailNode=tailNode.next;
        }
        while(tailNode!=null) {
            tailNode=tailNode.next;
            deleteNode = deleteNode.next;
        }

        if(deleteNode!=tmpHead) {
            deleteNode.next = deleteNode.next.next;
        }else {
            //删头
            head = head.next;
        }

        return head;
    }
}
