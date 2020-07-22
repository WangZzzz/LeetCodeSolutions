package old.Offer;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 	��94ҳ
 * 	������12����������n����˳���ӡ����1������nλ��������������3�����ӡ1��3��3.....999
 */
public class Print1ToMaxOfNDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Print1ToMaxOfN_2(3);
    }

    /*
     * ��ֱ�۵Ľⷨ�������10^n�η���Ȼ��ѭ����ӡ���������û�п��ǵ�n�ܴ�ʱ�����������
     */
    public static void Print1ToMaxOfN_1(int n) {
        int max = 1;
        for (int i = 1; i <= n; i++) {
            max = max * 10;
        }
        for (int i = 1; i < max; i++) {
            System.out.println(i);
        }
    }

    /*
     * �Ľ���ʹ��ArrayList���ϴ洢����
     */
    public static void Print1ToMaxOfN_2(int n) {
        // ��nlist��ʾ��n,nlist[0]��ʾn�����λ
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            nlist.add(0);//��ÿһλ������
        }
        increment(nlist);
    }

    // ʹ����ÿ��+1Ȼ�����
    public static void increment(ArrayList<Integer> nlist) {
        int carrybit = 0;//��λ
        boolean end = false;
        while (true) {
            for (int i = nlist.size() - 1; i >= 0; i--) {
                int digit = nlist.get(i);
//                System.out.println("digit" + i + ": " + digit);
                int sum = digit + carrybit;
                if (i == (nlist.size() - 1)) {
                    sum += 1;
                }
                System.out.println("sum : " + sum);
                if (sum >= 10) {
                    // ���λ������λ���ﵽ���ֵ��ֹͣ���
                    if (i == 0) {
                        //��ʱ�����λ�ˣ���Ҫ�˳�
                        end = true;
                    }
                    sum = sum - 10;
                    carrybit = 1;
                } else {
                    carrybit = 0;
                }
                nlist.set(i, sum);
            }
            output(nlist);
            if (end) {
                break;
            }
        }
    }

    // ������֣�����λ��0���
    public static void output(ArrayList<Integer> nlist) {
        Iterator<Integer> ite = nlist.iterator();
        int num;
        // �ҵ���һ��Ϊ0��λ��
        boolean first = false;
        while (ite.hasNext()) {
            if (first) {
                System.out.print(ite.next());
                continue;
            }
            if ((num = ite.next()) != 0) {
                first = true;
                System.out.print(num);
            }
        }
        System.out.println();
    }

}
