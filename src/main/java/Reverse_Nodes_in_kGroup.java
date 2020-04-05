/**
 * leetcode-25
 * */
public class Reverse_Nodes_in_kGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmpHead = new ListNode(-1);

        tmpHead.next = head;

        ListNode curNode = tmpHead;
        ListNode tailNode = curNode;

        boolean outOfIndex = false;

        while (curNode!=null && curNode.next != null) {
            // 查看当前节点的下K个节点

            System.out.println(curNode.val + "以后------");

            // 把接下来的k个节点的指针进行翻转
            // 确认前后指针指向

            for (int index = 0; index < k; index++) {
                if (tailNode.next == null) {
                    outOfIndex = true;
                    break;
                }
                tailNode = tailNode.next;
            }

            if(outOfIndex) {
                break;
            }

            System.out.println("尾节点："+tailNode.val);

            ListNode tmpCurNext = curNode.next;
            ListNode tmpTailNext = tailNode.next;
            tailNode.next = null;

            curNode.next = reverseList(curNode.next);
            tmpCurNext.next = tmpTailNext;

            for (int i = 0; i < k; i++) {
                if (curNode == null) {
                    break;
                }
                curNode = curNode.next;
            }
            tailNode = curNode;
            //System.out.println("refresh" + curNode.val);

        }

        return tmpHead.next;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //printNode(head);
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
