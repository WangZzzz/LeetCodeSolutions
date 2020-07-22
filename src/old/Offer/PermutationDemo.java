package old.Offer;

import java.util.Arrays;

/**
 * @author WangZ
 * ������28���ַ���������  154ҳ
 * ��Ŀ������һ���ַ�������ӡ�����ַ����е��ַ����������У����磬�����ַ���abc�����ӡ�����ַ�a��b��c�������г�����
 * �����ַ���abc��acb��bac��bca��cab��cba
 * ʵ�ʾ���ȫ����
 */
public class PermutationDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abc";
        Permutation(str);
    }

    public static void Permutation(String str) {
        if (str == null) {
            return;
        }
        char[] pStr = str.toCharArray();
        /*
         * ��Stringת����char�����飬�ڽ���ȫ����
         */
        perm(pStr, 0, pStr.length - 1);
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
