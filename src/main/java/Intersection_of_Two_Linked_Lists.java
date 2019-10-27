import java.util.HashMap;

/**
 * LeetCode-160
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        ListNode resNode = null;
        HashMap<ListNode, Integer> map = new HashMap();
        //A链表存进map
        while (pA != null) {
            map.put(pA,pA.val);
            pA = pA.next;
        }
        //遍历B，看是不是A中的元素，第一个元素就是交叉点
        while (pB != null) {
            if (map.get(pB) != null) {
                resNode = pB;
                break;
            }
            pB = pB.next;
        }
        return resNode;
    }
}
