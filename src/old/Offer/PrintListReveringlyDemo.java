package old.Offer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author WangZ
 * ������5����β��ͷ��ӡ���� 51ҳ
 * ��Ŀ������һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
 * ��������ջ��ʵ�֣�ͬ���ģ��ݹ���ǻ���ջ�ģ�Ҳ�������õݹ���ʵ��
 */
public class PrintListReveringlyDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        display(node1);
        System.out.println("*****");
        PrintListReveringly(node1);
        System.out.println("*****");
        PrintListReveringly2(node1);
    }

    //���ű���
    public static void display(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode current = node;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    //����ջ
    public static void PrintListReveringly(ListNode node) {
        if (node == null) {
            return;
        }

        ListNode current = node;
        LinkedList<ListNode> ll = new LinkedList<ListNode>();
        while (current != null) {
            ll.offerFirst(current);
            current = current.next;
        }

        while (!ll.isEmpty()) {
            ListNode tmp = ll.pollFirst();
            System.out.println(tmp.val);
        }
    }

    //���õݹ飬������Ҳ��ջ
    public static void PrintListReveringly2(ListNode node) {
        if (node == null) {
            return;
        }

        if (node.next != null)
            PrintListReveringly2(node.next);
        System.out.println(node.val);
    }

}
