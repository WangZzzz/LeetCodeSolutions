package old.Offer;

import java.util.Stack;

/*
 * 	������21������min������ջ ��132ҳ
 * 	��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min�������ڸ�ջ
 * 		�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)
 * 	 ʹ�ø���ջ������ջ��ʼ�մ洢��Сֵ
 */
public class StackWithMinDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.MyPush(3);
        stackWithMin.MyPush(4);
        stackWithMin.MyPush(2);
        stackWithMin.MyPush(1);
        System.out.println(stackWithMin.min());
        stackWithMin.MyPop();
        System.out.println(stackWithMin.min());
        stackWithMin.MyPop();
        System.out.println(stackWithMin.min());
        stackWithMin.MyPush(0);
        System.out.println(stackWithMin.min());
    }

    public static class StackWithMin {

        public Stack<Integer> m_data = new Stack<>();//����ջ
        public Stack<Integer> m_min = new Stack<>();//����ջ

        public void MyPush(int value) {
            m_data.push(value);
            if (m_min.size() == 0 || value < (int) m_min.peek()) {
                m_min.push(value);
            } else {
                m_min.push((int) m_min.peek());
            }
        }

        public void MyPop() {
            assert (m_data.size() > 0 && m_min.size() > 0);

            m_data.pop();
            m_min.pop();
        }

        public int min() {
            //���ԣ�������Դ��󣬻���ֹ����
            assert (m_data.size() > 0 && m_min.size() > 0);

            return (int) m_min.peek();
        }
    }

}
