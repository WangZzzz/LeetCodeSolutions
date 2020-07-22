package util;

import java.security.SecureRandom;

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

    public static void swap(int[] arr, int i, int j) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

    public static int[] createTestArray(int n) {
        SecureRandom random = new SecureRandom((System.currentTimeMillis() + "").getBytes());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = random.nextInt(10);
            if (1 == tmp || 3 == tmp || 5 == tmp || 7 == tmp) {
                array[i] = random.nextInt(n * 50);
            } else {
                array[i] = -random.nextInt(n * 50);
            }

        }
        return array;
    }
}
