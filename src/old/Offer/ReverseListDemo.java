package old.Offer;


/*
 * 	��112ҳ
 * 		������16����ת����
 * 		��Ŀ������һ������������һ�������ͷ��㣬��ת�����������ת�����ͷ���
 *
 * 	˼·����Ҫ����ָ�룬��ǰ��㣬ǰһ����㣬��һ�����
 */
public class ReverseListDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        disPlay(ll.head);

        disPlay(ReverseList(ll.head));
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {//û�н��
            return null;
        }

        if (head.next == null) {
            //ֻ��һ�����
            return head;
        }

        ListNode previous = null;//ͷ����ǰһ�������null
        ListNode current = head;
        ListNode ReverseHead = null;//��ת��Ľ��ͷ��
        while (current != null) {
            ListNode pNext = current.next;
            if (pNext == null) {
                //˵�������һ�������
                ReverseHead = current;
            }
            current.next = previous;//��ǰ���ָ��ǰһ�����
            previous = current;//ǰһ���������Ϊ��ǰ���
            current = pNext;//��ǰ�������Ϊ�ղű�������һ�����
        }
        return ReverseHead;
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
