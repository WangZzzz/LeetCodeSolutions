package old.Offer;

import java.util.LinkedList;


/*
 * Լɪ�����⣬n����ΧһȦ���ӵ�һ���˿�ʼ������������m���˳�������һ����ʼ���±���������m���˳�
 * 	����ʹ��ѭ������
 */

public class JosephusProblemDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test(2, 9);
    }

    public static void Test(int m, int n) {
        CircleLinkList<String> cll = new CircleLinkList<String>();
        for (int i = n; i > 0; i--) {
            cll.addFirstNode("Person" + i);
        }
        cll.displayAllNodes1();
        System.out.println(cll.count);
        int cnt = 1;
        int index = 0;
        while (true) {
            if (cnt == m) {
                System.out.println("delete : " + cll.deleteByIndex(index));
                index--;
                cnt = 0;
            } else {
                cnt++;
                index++;
            }
            if (index == cll.count) {
                index = 0;
            }
/*			if(cll.count == 15){
				break;
			}	*/
            if (cll.count == 0) {
                break;
            }
        }
        System.out.println("*************");
        cll.displayAllNodes1();
    }
}

class CircleLinkList<T> {
    public Node<T> head;//ͷ���
    public Node<T> tail;//β�ڵ�
    public int count = 0;//�ڵ�����

    class Node<T> {
        private T t;
        public Node<T> next;

        public Node(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public CircleLinkList() {
        head = null;
        tail = null;
    }

    public void clear() {//ɾ�����н��
        head.next = null;
        tail.next = null;
        head = null;
        tail = null;
    }

    //��ͷ���ǰ�����ڵ�
    public void addFirstNode(T t) {
        Node<T> node = new Node<T>(t);
        if (head == null) {//��ʱ��û��Ԫ��
            head = node;
            tail = node;
            head.next = head;
            tail.next = tail;
            count++;
        } else {
            node.next = head;
            tail.next = node;
            head = node;
            count++;
        }
    }

    //ɾ��ͷ��㣬������
    public T deleteFirstNode() {
        if (head == null) {
            return null;
        } else {
            Node<T> tmpNode = head;
            head = head.next;
            tail.next = head;
            count--;
            return tmpNode.t;
        }
    }

    public void addLastNode(T data) {//��β������ڵ�
        Node<T> node = new Node<T>(data);
        if (tail == null) {
            tail = node;
            head = node;
            tail.next = tail;
            head.next = head;
            count++;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
            count++;
        }
    }


    //��ָ��λ�ò���ڵ�
    public void addByIndex(int index, T t) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("����Խ��");
        }
        if (index == 0) {
            addFirstNode(t);
        } else if (index == count - 1) {
            addLastNode(t);
        } else {
            Node<T> node = new Node<T>(t);
            Node<T> current = head;
            Node<T> previous = head;
            int tmp = 0;
            while (tmp != index) {
                previous = current;
                current = current.next;
                tmp++;
            }
            previous.next = node;
            node.next = current;
            count++;
        }
    }

    //ɾ��ָ��λ�õĽڵ�
    public T deleteByIndex(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("ɾ��Խ�� : " + index);
        } else if (count == 1) {//��ֻ��һ��Ԫ��ʱ
            System.out.println("$$$");
            Node<T> node = head;
            head = null;
            tail = null;
            count--;
            return node.t;
        } else if (index == 0) {//��ɾ����Ԫ���ǵ�һ��Ԫ��ʱ
            return deleteFirstNode();
        } else {
            int tmp = 0;
            Node<T> current = head;//ָ��ǰ�ڵ�
            Node<T> previous = head;//ָ��ǰ�ڵ��ǰһ���ڵ�
            while (tmp != index) {
                previous = current;
                current = current.next;
                tmp++;
            }
            previous.next = current.next;
            count--;
            return current.t;
        }
    }

    //�����������ҽڵ�
    public Node<T> findByIndex(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("ɾ��Խ��");
        }
        int tmp = 0;
        Node<T> current = head;
        while (tmp != index) {
            current = current.next;
            tmp++;
        }
        return current;
    }

    //�������ݲ��ҽڵ������ֵ
    public int IndexOf(T t) {
        Node<T> current = head;
        int index = 0;
        while (current.getT() != t) {
            if (current.next == null) {
                return -1;//���ҵ����һ���ڵ㣬û�в��ҵ����ݣ�����-1
            }
            current = current.next;
            index++;
        }
        return index;
    }

    //��ʾ���нڵ�
    public void displayAllNodes1() {
        if (head != null) {
            Node<T> current = head;
            while (true) {
                System.out.println(current.t);
                if (current.next == head) {
                    //���һ���ڵ���
                    break;
                }
                current = current.next;
            }
        }
    }

    /*
     * ��β�ڵ㿪ʼ��ӡ�����Ԫ�أ�˼·�����Խ����������е�Ԫ�أ�
     * ��Ԫ��ʹ��offerFirst�ķ�������LinkerList�У�Ȼ����pollFirst�ķ���ȡ��,
     * ʵ����ʵ����һ��ջ�Ľṹ������ȳ�
     */
    public void displayAllNodes2() {
        if (head != null) {
            Node<T> current = head;
            LinkedList<T> ll = new LinkedList<T>();
            while (true) {
                ll.offerFirst(current.getT());
                if (current.next == head) {
                    break;
                }
                current = current.next;
            }
            T t = null;
            while ((t = ll.pollFirst()) != null) {
                System.out.println(t);
            }
        }
    }

    /*
     * ���Ǵ�β����ӡԪ�أ���Ȼ�뵽��ջ�����ݹ鱾���Ͼ���һ��ջ�ṹ�������ʵ�һ�����ʱ��
     * �����ȵݹ�������ĺ����ڵ�
     * 	ע�⣺���ڵݹ�Ĵ��뿴�����ܼ�࣬�����и����⣬������ǳ���ʱ���ͻᵼ�º������õ�
     * 		�㼶����Ӷ��п��ܵ��µ���ջ������ڶ��ַ�����³����Ҫ��һЩ��
     */
    public void displayAllNodes3(Node<T> node) {
        if (node != null) {
            if (node.next != head) {
                displayAllNodes3(node.next);
            }
            System.out.println(node.getT());
        }
    }
}
