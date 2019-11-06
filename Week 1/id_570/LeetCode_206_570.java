import com.sun.javafx.stage.FocusUngrabEvent;

import java.net.HttpURLConnection;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。
 * -----------------------------------------
 * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 */
public class LeetCode_206_570 {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode last = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4);
        four.next = five;
        ListNode three = new ListNode(3);
        three.next = four;
        ListNode two = new ListNode(2);
        two.next = three;
        ListNode one = new ListNode(1);
        one.next = two;

        System.out.println(new LeetCode_206_570().reverseList(one).val);
    }
}




