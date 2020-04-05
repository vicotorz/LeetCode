
/**
 * leetcode-61
 * */
public class Rotate_List {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int length = getListLength(head);
        //System.out.println(length);
        if (k >= length) {
            k = k % length;

            if (k == 0) {
                return head;
            }
        }

        ListNode slowNode = head;
        ListNode fastNode = head;

        for (int i = 0; i < k; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        ListNode reverseNodeHead = slowNode.next;
        slowNode.next = null;
        fastNode.next = head;

        return reverseNodeHead;
    }

    public static int getListLength(ListNode head) {
        ListNode curNode = head;

        int length = curNode == null ? 0 : 1;
        while (curNode != null && curNode.next != null) {
            length++;
            curNode = curNode.next;
        }
        return length;
    }
}
