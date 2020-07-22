package old.Offer;

/*
 * 	��107ҳ
 * 	������15�������е�����k�����
 * 		��Ŀ������һ����������������е�����k����������Ϊ�˷��ϴ�����˵�ϰ�ߣ�
 * 	�����1��ʼ�������������β����ǵ�����һ�����
 */
public class FindKthToTailDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList ll1 = new LinkedList();
        ll1.addFirst(15);
        ll1.addFirst(12);
        ll1.addFirst(9);
        ll1.addFirst(7);
        ll1.addFirst(2);

        System.out.println(FindKthToTail(ll1.head, 2).val);
    }

    /*
     * ˼·��������k�����͵�����һ�����֮�䣬���k-1����㣬���Կ��Զ�������ָ�룬ͬʱ
     * 	ָ������ͷ������һ��ָ�����ƶ�k-1������ʱ����ָ��ͬʱ�ƶ�������һ��ָ��ָ��βָ��ʱ���������
     * 	���k-1������ʱ�ڶ���ָ����ָ�Ľ�����������
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode pAhead = head;
        ListNode pBehind = null;
        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null) {//���������û������������С��k��������жϣ��ᷢ����ָ���쳣
                pAhead = pAhead.next;
            } else {
                return null;
            }
        }

        pBehind = head;
        while (pAhead.next != null) {//��pAhead.nextΪ��ʱ��˵���Ѿ�ָ�������һ�����
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }
}