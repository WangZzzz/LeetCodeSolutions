import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br>
 * <p>
 * {@link Solution2}
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author wangzhe
 * @date 2019/1/7 19:05
 */
public class Solution2 {


    public static void main(String[] args) {
//        ListNode l1 = CommonUtils.createListNode(new int[]{2, 4, 3});
//        ListNode l2 = CommonUtils.createListNode(new int[]{5, 6, 4});
        ListNode l1 = CommonUtils.createListNode(new int[]{5});
        ListNode l2 = CommonUtils.createListNode(new int[]{5});
        ListNode resNode = addTwoNumbers(l1, l2);
        CommonUtils.printListNode(resNode);
//
//        System.out.println(Arrays.toString(sNumList.toArray()));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        int num1 = 0;
        int num2 = 0;
        ListNode l1Next = null;
        ListNode l2Next = null;
        if (l1 != null) {
            num1 = l1.val;
            l1Next = l1.next;
        }
        if (l2 != null) {
            num2 = l2.val;
            l2Next = l2.next;
        }
        int tmp = num1 + num2 + carry;
        if (tmp > 9) {
            carry = 1;
            tmp = tmp - 10;
        } else {
            carry = 0;
        }
        ListNode listNode = new ListNode(tmp);
        //递归调用，当下个节点中某一个不为空，或者进位不为空时，递归
        if (l1Next != null || l2Next != null || carry != 0) {
            listNode.next = addTwoNumbers(l1Next, l2Next, carry);
        }
        return listNode;
    }
}
