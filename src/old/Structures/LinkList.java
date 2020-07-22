package old.Structures;

import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.Node;

/*
 * ��������
 */
public class LinkList<T> {
    public Node<T> head;//ͷ���
    private int count = 0;//�ڵ�����

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

    public LinkList() {
        head = null;
    }

    public void clear() {//ɾ�����н��
        head.next = null;
        head = null;
    }

    //��ͷ���ǰ�����ڵ�
    public void addFirstNode(T t) {
        Node<T> node = new Node<T>(t);
        node.next = head;
        head = node;
        count++;
    }

    //ɾ��ͷ��㣬������
    public Node<T> deleteFirstNode() {
        if (head == null) {
            return null;
        }
        Node<T> tmpNode = head;
        head = head.next;
        count--;
        return tmpNode;
    }

    //��ָ��λ�ò���ڵ�
    public void addByIndex(int index, T t) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("����Խ��");
        }
        if (index == 0) {
            addFirstNode(t);
        }
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

    //ɾ��ָ��λ�õĽڵ�
    public Node<T> deleteByIndex(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("ɾ��Խ��");
        }
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
        return current;
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
                System.out.println(current.getT());
                if (current.next == null) {
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
                if (current.next == null) {
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
            if (node.next != null) {
                displayAllNodes3(node.next);
            }
            System.out.println(node.getT());
        }
    }
}
