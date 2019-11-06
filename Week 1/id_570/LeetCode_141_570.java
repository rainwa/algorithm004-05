import com.sun.tools.javac.comp.Infer;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 */
public class LeetCode_141_570 {

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode node = head;
        int n = 0;
        int pos = -1;
        while (null != node) {
            if (map.containsKey(node)) {
                pos = map.get(node);
                break;
            }
            map.put(node, n);
            if (null == node.next) {
                pos = -1;
                break;
            }
            node = node.next;
        }
        System.out.println("pos: "+pos);
        if (-1 == pos) {
            return false;
        } else return true;
    }
}
