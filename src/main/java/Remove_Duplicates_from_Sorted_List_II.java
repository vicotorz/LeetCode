import java.util.HashMap;
/**
 * leetcode-82
 * */
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode resultHead = new ListNode(-1);
        ListNode result = resultHead;

        ListNode curNode = head;

        HashMap<Integer, Integer> map = new HashMap();

        while (curNode != null) {
            map.put(curNode.val, map.getOrDefault(curNode.val, 0) + 1);
            curNode = curNode.next;
        }

        curNode = head;

        while (curNode != null) {
            //System.out.println(curNode.val + "-------" + map.get(curNode.val));
            if (map.get(curNode.val) == 1) {
                //System.out.println("lianjie");
                result.next = new ListNode(curNode.val);
                result = result.next;
            }
            curNode = curNode.next;
        }

        return resultHead.next;
    }
}
