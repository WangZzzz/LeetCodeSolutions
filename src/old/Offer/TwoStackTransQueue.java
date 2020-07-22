package old.Offer;

import java.util.Stack;
/*
 * 	��ָoffer 59ҳ
 * 	��Ŀ��ʹ������ջʵ��һ�����У����е��������£���ʵ��������������appendTail��
 * 		deleteHead���ֱ��ڶ���β������ڵ���ڶ���ͷ��ɾ���ڵ�Ĺ���
 * 	ԭ������ջs1��s2�����Ԫ��ʱ��ӵ�s1�У�ɾ��Ԫ��ʱ���Ȱ�s1�е�ȫ��Ԫ���Ƶ�s2�У�Ȼ���
 * 		s2��ȡ������һ��ȡ��ʱ��s1�Ѿ��ǿյ��ˣ�ֱ�Ӵ�s2��ȡ��һ��Ԫ��
 */

public class TwoStackTransQueue {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.appendTail(1);
        mq.appendTail(2);
        mq.appendTail(3);
        mq.appendTail(4);
        System.out.println(mq.deleteHead());
        mq.appendTail(5);
        System.out.println(mq.deleteHead());
        System.out.println(mq.deleteHead());
        System.out.println(mq.deleteHead());
        System.out.println(mq.deleteHead());
    }

}

class MyQueue<T> {
    private Stack<T> s1 = new Stack<T>();
    private Stack<T> s2 = new Stack<T>();

    public MyQueue() {
    }

    ;

    public void appendTail(T data) {
        s1.push(data);
    }

    public T deleteHead() {
        if (s2.size() <= 0) {//��s2������ʱ��˵���Ѿ����й��˲������ˣ�ֱ�Ӵ�s2��ȡ��Ԫ�ؼ���
            while (s1.size() > 0) {
                T data = s1.pop();
                s2.push(data);
            }

            if (s2.size() == 0) {
                throw new RuntimeException("queue is empty");
            }
        }

        T head = s2.pop();
        return head;
    }
}