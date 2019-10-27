/**
 * LeetCode-23
 * 复用合并两个链表逻辑
 */
public class Merage_k_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }

        if(l2==null) {
            return l1;
        }

        ListNode tmpNode = null;
        if(l1.val<l2.val) {
            tmpNode = new ListNode(l1.val);
            tmpNode.next = mergeTwoLists(l1.next,l2);
        }else {
            tmpNode = new ListNode(l2.val);
            tmpNode.next = mergeTwoLists(l1,l2.next);
        }
        return tmpNode;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //注意边界条件
        if(lists.length==0) {
            return null;
        }
        ListNode res = lists[0];
        for(int i=1;i<lists.length;i++) {
            res = mergeTwoLists(res,lists[i]);
        }
        return res;
    }
}
