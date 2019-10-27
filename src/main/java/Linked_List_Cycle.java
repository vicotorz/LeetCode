/**
 * LeetCode-141
 */
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head ==null||head.next==null) {
            return false;
        }
        boolean result = true;
        //慢节点，快节点
        ListNode low = head;
        ListNode quick = head.next;
        while(low!=quick) {
            if(quick == null||quick.next == null) {
                result = false;
                break;
            }
            low = low.next;
            quick = quick.next.next;
        }
        return result;
    }
}
