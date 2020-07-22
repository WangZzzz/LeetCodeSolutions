package old.Offer;


/*
 * 	��99ҳ
 * 	������13����O(1)���¼�ɾ�������㣺�������������ͷָ���һ�����ָ�룬����һ��������O(1)
 * 		ʱ��ɾ���ý��
 *	˼·�����Ǻ������ҵ�Ҫɾ��������һ����㣬���������ֵ���Ƹ�Ҫɾ���Ľ�㣬ͬʱ��Ҫɾ��
 *		�Ľ��ָ����һ��������һ����㼴�ɣ����ǵÿ������������
 *			1.ֻ��һ�����
 *			2.Ҫɾ������β��㣬������һ�����Ϊ��
 */
public class DeleteNodeDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
    }

    public static void DeleteNode(ListNode head, ListNode Delete) {
        if (head == null || Delete == null) {
            return;
        }

        if (head == Delete) {
            //����ֻ��һ��ͷ���
            head = null;
            Delete = null;
        } else if (Delete.next == null) {
            //��ʱ�������ж����㣬��Ҫɾ���Ľ����β���
            //�������ֻ��ʹ��˳�����
            ListNode current = head;
            while (current.next != Delete) {
                current = current.next;
            }
            //��ʱcurrent.next == Delete;
            //Ҫɾ��β��㡣ֻ��Ҫ��current.next = null;
            current.next = null;
            Delete = null;
        } else if (Delete.next != null) {
            //Ҫɾ���Ľ�㲻��β���
            ListNode tmp = Delete.next;
            Delete.val = tmp.val;
            Delete.next = tmp.next;
            tmp = null;
        }
    }

}

