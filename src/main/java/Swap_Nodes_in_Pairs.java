/***
 * leetcode-24
 */


public class Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        ListNode tmpHead = new ListNode(-1);

        tmpHead.next = head;

        ListNode curNode = tmpHead;

        while (curNode != null) {
            // 查看当前节点的下两个节点
            // 如果下两个节点只有一个，则不交换
            //System.out.println(curNode.val + "------");

            ListNode swapNode1 = curNode.next;
            if(swapNode1 == null) {
                break;
            }

            ListNode swapNode2 = swapNode1.next;

            if (swapNode2 == null) {
                break;
            } else {
                // 交换
                //System.out.println("swap" + swapNode1.val + "-----" + swapNode2.val);
                ListNode tmpNode = swapNode2.next;
                curNode.next = swapNode2;
                swapNode2.next = swapNode1;
                swapNode1.next = tmpNode;
            }

            curNode = curNode.next.next;
            //System.out.println("refresh" + curNode.val);

        }

        return tmpHead.next;
    }
}
