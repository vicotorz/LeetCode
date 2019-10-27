/**
 * LeetCode-142
 */
public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //按照老方法判断是否有环
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        // 如果没有环，则返回
        if ((fast == null) || (fast.next == null))
            return null;

        //如果有环，slow定位到head，quick不动再重新确认一下位置
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // or fast
    }
}
