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

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val;
            int carry = 0;
            if (tmp > 9) {
                carry = 1;
                tmp = tmp - 9;
            } else {
                carry = 0;
            }
            ListNode resListNode = new ListNode(tmp);


        }

        throw new IllegalArgumentException("no such solution!");
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
