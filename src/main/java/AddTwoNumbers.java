/**
 * Leedcode-2
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;

        int carry = 0;
        while(l1!=null||l2!=null) {
            int tmpRes = 0;
            if(l1!=null && l2!=null) {//两个点都有值
                tmpRes = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1!=null) {//l1有值
                tmpRes = l1.val + carry;
                l1 = l1.next;
            }else if(l2!=null) {//l2有值
                tmpRes = l2.val + carry;
                l2 = l2.next;
            }
            //计算进位
            if(tmpRes>=10) {
                tmpRes = tmpRes % 10;
                carry = 1;
            }else {
                carry = 0;
            }
            //合并结果
            res.next = new ListNode(tmpRes);
            res = res .next;
        }
        //计算最后一个值
        if(carry==1) {
            res.next = new ListNode(1);
        }
        return head.next;
    }
}
