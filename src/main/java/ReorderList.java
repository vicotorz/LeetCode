
/**
 * leetcode-143
 * */
public class ReorderList {

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        //printList(head);

        ListNode cur = head;
        ListNode cur1;
        ListNode cur2;

        int size = getSize(head);

        // 拆分list
        for (int i = 1; i <= size / 2; i++) {
            cur = cur.next;
        }

        cur2 = cur.next;
        cur.next = null;
        cur1 = head;

        getSize(cur1);
        getSize(cur2);


        // 逆序 list
        ListNode reverseNode2 = reverseList(cur2);
        getSize(reverseNode2);

        cur2 = reverseNode2;

        ListNode result = new ListNode(-1);
        ListNode cur3 = result;

        // 重构list
        while (true) {
            if (cur1 == null && cur2 == null) {
                break;
            } else if (cur1 == null) {
                cur3.next = cur2;
                break;
            } else if (cur2 == null) {
                cur3.next = cur1;
                break;
            } else {
                cur3.next = cur1;
                cur1 = cur1.next;
                cur3 = cur3.next;


                cur3.next = cur2;
                cur3 = cur3.next;
                cur2 = cur2.next;
            }

        }
        //System.out.println("拼装成功");
        head = result.next;
        getSize(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static int getSize(ListNode head) {
//		Scanner sc = new Scanner(System.in);
//		sc.hasNextLine();

        int size = 0;
        while (head != null) {
            //System.out.print(head.val + "------");
            head = head.next;
            size++;
        }
        //System.out.println();
        return size;
    }
}
