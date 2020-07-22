package old.Leetcode;



/*
 * ��21��leetcode
 */

public class mergeTwoListsDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        ll1.addFirst(15);
        ll1.addFirst(12);
        ll1.addFirst(9);
        ll1.addFirst(7);
        ll1.addFirst(2);

        disPlay(ll1.head);

        System.out.println("*****");

        ll2.addFirst(18);
        ll2.addFirst(12);
        ll2.addFirst(10);
        ll2.addFirst(5);
        ll2.addFirst(3);

        disPlay(ll2.head);

        System.out.println("*****");

        ListNode node = mergeTwoLists(ll1.head, ll2.head);

        disPlay(node);


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);//ͷָ�룬��ֵΪ0
        ListNode tail = head;//�ٶ���һ��βָ�룬������β��̨�ھ���Ԫ��
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode tmp = new ListNode(l1.val);
                tail.next = tmp;
                tail = tmp;
                l1 = l1.next;
            } else {
                ListNode tmp = new ListNode(l2.val);
                tail.next = tmp;
                tail = tmp;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            ListNode tmp = new ListNode(l1.val);
            tail.next = tmp;
            tail = tmp;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode tmp = new ListNode(l2.val);
            tail.next = tmp;
            tail = tmp;
            l2 = l2.next;
        }

        return head.next;//����ͷָ��Ϊ0�����Ե÷�����һ��
    }

    public static void disPlay(ListNode node) {
        ListNode current = node;
        if (current == null) {
            return;
        } else {
            while (current != null) {
                System.out.println(current.val);
                current = current.next;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class LinkedList {
    public ListNode head;

    public LinkedList() {
        head = null;
    }

    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}