package old.Offer;

/*
 * ��78ҳ
 * ������10����������1�ĸ�����
 * 	��Ŀ����ʵ��һ������������һ��������������������Ʊ�ʾ��1�ĸ���
 *
 * ע�⣺��Ҫ��n = n >> 1������n = n/2����Ϊλ�����Ч�ʸ�
 */
public class NumberOf1Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(NumberOf12(0xFFFFFFFF));
    }

    public static int NumberOf1(int n) {
        //���ַ���������0x80000000��������ѭ����
        //��Ϊ�������ԭ��Ϊ����ʱ������nλ�������Ҫ��n��1
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    /*
     * ˼·����һ�з����ǽ�n���ƣ����ǿ��Խ���n�Ƚϵ�����һ������һλ��
     * ������ÿ�ζ����ж�n������һλ�ǲ���1
     */
    public static int NumberOf12(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) == 1)
                count++;
            flag = flag << 1;//����һλ
        }

        return count;
    }

    /*
     *
     */
    public static int NumberOf13(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }

        return count;
    }

}
