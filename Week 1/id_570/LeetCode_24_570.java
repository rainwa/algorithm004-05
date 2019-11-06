/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *  
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class LeetCode_24_570 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        ListNode lastBehind = pre;

        ListNode front;
        ListNode behind;
        while (null!=temp.next && null!=temp.next.next) {
//            if (temp == pre) {
//                pre.next = head.next;
//
            front = temp.next.next;
            behind = temp.next;
            behind.next = front.next;
            front.next = behind;
            lastBehind.next = front;
            lastBehind = behind;
            temp = behind;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode head = new LeetCode_24_570().swapPairs(one);
        ListNode node = head;
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
