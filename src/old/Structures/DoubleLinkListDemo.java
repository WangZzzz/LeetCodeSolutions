package old.Structures;

/*
 * ˫����������ѭ����
 */

public class DoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleLinkList<String> dll = new DoubleLinkList<String>();
/*		dll.addFirst("test1");
		dll.addFirst("test2");
		dll.addFirst("test3");
		dll.addFirst("test4");
		dll.displayAllNodes1();
		System.out.println("******");
		dll.displayAllNodes2();*/

        dll.addLast("test1");
        dll.addLast("test2");
        dll.addLast("test3");
        dll.addLast("test4");
        dll.addLast("test5");
        dll.addLast("test6");
        dll.addLast("test7");
        dll.addLast("test8");
        dll.addLast("test9");
        dll.displayAllNodes1();
        System.out.println("******");
        dll.displayAllNodes2();
        dll.add(3, "test11");
        System.out.println("******");
        dll.displayAllNodes1();
        System.out.println("******");
        System.out.println("removeFirst : " + dll.removeFirst());
        dll.displayAllNodes1();
        System.out.println("******");
        System.out.println("removeLast : " + dll.removeLast());
        dll.displayAllNodes1();
        System.out.println("******");
        System.out.println("remove : " + dll.removeByIndex(1));
        System.out.println("******");
        dll.displayAllNodes1();
        System.out.println("******");
        System.out.println("remove1 : " + dll.removeByIndex(1));
        System.out.println("******");
        dll.displayAllNodes1();
        System.out.println("******");
        dll.displayAllNodes3(dll.head);
        System.out.println("******");
        dll.displayAllNodes4(dll.tail);
    }
}

class DoubleLinkList<T> {
    class Node<T> {
        T data;
        Node<T> pres;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            pres = null;
            next = null;
        }

        public T getT() {
            return data;
        }
    }

    public Node<T> head;
    public Node<T> tail;
    public int size;//�����С

    public DoubleLinkList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T data) {//��ͷ����ӽ��
        Node<T> node = new Node<T>(data);
        if (head == null) {//˵����ʱ��û�н��
            head = node;
            tail = node;
            size++;
        } else {
            node.next = head;
            head.pres = node;
            head = node;
            size++;
        }
    }

    public void addLast(T data) {//��β����ӽ��
        Node<T> node = new Node(data);
        if (tail == null) {//˵����ʱ��û�н��
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            node.pres = tail;
            tail = node;
            size++;
        }
    }

    public void add(int index, T data) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size - 1) {
            addLast(data);
        } else {
            Node<T> node = new Node(data);
            Node<T> current = head;
            Node<T> previous = head;
            int cnt = 0;
            while (cnt != index) {
                previous = current;
                current = current.next;
                cnt++;
            }
            previous.next = node;
            node.pres = previous;
            node.next = current;
            current.pres = node;
            size++;
        }
    }

    public void clear() {//������н��
        head.next = null;
        tail.pres = null;
        head = null;
        tail = null;
        size = 0;
    }

    public T removeFirst() {//ɾ����һ����㣬����������
        if (head == null) {
            return null;
        } else {
            Node<T> node = head;
            if (head.next == null) {//ֻ��һ�����
                head = null;
                tail = null;
                size--;
                return node.data;
            } else {
                head = head.next;
                head.pres = null;
                size--;
                return node.data;
            }
        }
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        } else {
            Node<T> node = tail;
            if (tail.pres == null) {//��ʱֻ��һ�����
                tail = null;
                head = null;
                size--;
                return node.data;
            } else {
                tail = tail.pres;
                tail.next = null;
                size--;
                return node.data;
            }
        }
    }

    public T removeByIndex(int index) {//����ָ����������ɾ�����
        if (index < 0 || index >= size) {
            return null;//Խ��
        } else {
            if (index == 0) {
                return removeFirst();
            } else if (index == size - 1) {
                return removeLast();
            } else {
                int tmp = 0;
                Node<T> current = head;
                Node<T> previous = head;
                while (tmp != index) {
                    previous = current;
                    current = current.next;
                    tmp++;
                }
                previous.next = current.next;
                current.next.pres = previous;
                size--;
                return current.data;
            }
        }
    }

    public T getData(int index) {//����ָ��������ȡ����
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {//��һ�����
            return head.data;
        } else if (index == size - 1) {//���һ�����
            return tail.data;
        } else {
            Node<T> current = head;
            int tmp = 0;
            while (tmp != index) {
                current = current.next;
            }
            return current.data;
        }
    }

    /*
     * ��ͷ��㿪ʼ����
     */
    public void displayAllNodes1() {
        if (head != null) {
            Node<T> current = head;
            while (true) {
                System.out.println(current.data);
                if (current.next == null) {//˵����ʱ�����һ�����
                    break;
                }
                current = current.next;
            }
        }
    }

    public void displayAllNodes2() {
        if (tail != null) {
            Node<T> current = tail;
            while (true) {
                System.out.println(current.data);
                if (current.pres == null) {//˵����ʱ�ǵ�һ�����
                    break;
                }
                current = current.pres;
            }
        }
    }

    public void displayAllNodes3(Node<T> node) {//�ݹ鷽ʽ,����Ĳ�����ͷ���
        if (node != null) {
            if (node.next != null) {
                displayAllNodes3(node.next);
            }
            System.out.println(node.data);
        }
    }

    public void displayAllNodes4(Node<T> node) {//�ݹ鷽ʽ,����Ĳ�����β�ڵ�
        if (node != null) {
            if (node.pres != null) {
                displayAllNodes4(node.pres);
            }
            System.out.println(node.data);
        }
    }
}