package old.Offer;

import java.util.Stack;

/**
 * @author WangZ
 * ������22��ջ��ѹ�롢��������  ��134ҳ
 * ��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ������У�����ѹ��ջ���������־�����ȡ�
 * <p>
 * ˼·��
 * ��һ��ջ��������˳������ѹ�����к͵������У������ǰλ����ѹ�����к͵�������ֵ��ȣ�ֱ�Ӷ������һ��Ԫ�أ�
 * �Ƚ�ջ��Ԫ�غ͵������е�ǰֵ�������ȣ���ջ���������к���һ��Ԫ�أ������������ѹ�����е�ǰֵѹջ��ѹ�����к���һ��Ԫ�ء�
 * �������󣬵������ж������꣬˵���������в��Ϸ���ʱ�临�Ӷ�ΪO(n)��
 */
public class IsPopOrderDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] pPush = {1, 2, 3, 4, 5};
        int[] pPop = {4, 5, 3, 2, 1};
//		int[] pPop = {4,3,5,1,2};
        System.out.println(isPopOrder(pPush, pPop));

    }

    public static boolean isPopOrder(int[] pPush, int[] pPop) {
        if (pPush == null || pPop == null || pPush.length <= 0 || pPop.length <= 0) {
            return false;
        }
        Stack<Integer> tmpStack = new Stack<Integer>();
        int i = 0, j = 0;
        int n1 = pPush.length;//ѹ�����еĳ���
        int n2 = pPop.length;//��ջ���еĳ���
        // ���ÿ����ջ
        while (j < n2) {
            while (i < n1 && pPush[i] != pPop[j]) {
                // ������ȣ���һֱ��ջ
                tmpStack.push(pPush[i]);
                i++;
            }
            //��ȵ�Ԫ��û�н�ջ
            i++;
            j++;
            int top = 0;

            while (!tmpStack.isEmpty() && ((top = tmpStack.pop()) == pPop[j])) {
                j++;
            }

            if (j < n2) {
                tmpStack.push(top);
            }
            // ���Ѿ��Ҳ�����ջԪ��ʱ�˳�
            if (i >= n1 && !tmpStack.isEmpty()) {
                break;
            }
        }

        if (tmpStack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

}
