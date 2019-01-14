import jdk.nashorn.internal.ir.LiteralNode;

import java.util.List;

public class CommonUtils {

    /**
     * printListNode 打印单向链表
     *
     * @param listNode
     * @return void
     * @author WangZhe
     * @since 1.0
     */
    public static void printListNode(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                System.out.print(listNode.val + "->");
                printListNode(listNode.next);
            } else {
                System.out.print(listNode.val);
                System.out.println();
            }
        }
    }


    public static ListNode createListNode(int[] nums) {
        if (nums != null && nums.length > 0) {
            ListNode rootNode = new ListNode(nums[0]);
            ListNode otherNode = rootNode;
            for (int i = 1; i < nums.length; i++) {
                ListNode tmpNode = new ListNode(nums[i]);
                otherNode.next = tmpNode;
                otherNode = tmpNode;
            }
            return rootNode;
        }
        return null;
    }
}
