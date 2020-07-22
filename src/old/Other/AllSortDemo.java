package old.Other;

/**
 * @author WangZ
 * ȫ�����㷨��javaʵ��
 */
public class AllSortDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] arr = "abc".toCharArray();
        perm(arr, 0, arr.length - 1);
    }


    public static void perm(char[] buf, int start, int end) {
        if (start == end) {// ��ֻҪ���������һ����ĸ����ȫ����ʱ��ֻҪ�Ͱ��������������
            System.out.println(buf);
        } else {// �����ĸȫ����
            for (int i = start; i <= end; i++) {
                char temp = buf[start];// ���������һ��Ԫ���������Ԫ��
                buf[start] = buf[i];
                buf[i] = temp;

                perm(buf, start + 1, end);// ����Ԫ�صݹ�ȫ����

                temp = buf[start];// ������������黹ԭ
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }
}
