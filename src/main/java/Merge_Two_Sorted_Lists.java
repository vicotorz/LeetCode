/**
 * LeetCode-21
 */
public class Merge_Two_Sorted_Lists {
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
            tmpNode.next = mergeTwoLists(l1.next,l2);//容易出错，指向下一个
        }else {
            tmpNode = new ListNode(l2.val);
            tmpNode.next = mergeTwoLists(l1,l2.next);//容易出错，指向下一个
        }
        return tmpNode;
    }
}
