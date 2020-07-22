package old.Offer;

/**
 * @author WangZ
 * ������32����1��n������1���ֵĴ��� 174ҳ
 * ��Ŀ������һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ��������磬����12����1��12�а���1��������1,10��11,12��һ��������5��
 */
public class NumberOf1Between1AndNDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(NumberOf1Between1AndN(12));
    }

    /*
     * 	˼·���ۼӴ�1��n��ÿ������1���ֵĴ���������ͨ����10ȡ�����ж������ĸ�λ�����ǲ���1�����������ִ���10�����Գ���10֮��
     * 	���жϸ�λ�����ǲ���1��
     * 	ʱ�临�Ӷȣ�������������n��n��O(logn)λ����Ҫ�ж�ÿһλ�ǲ���1��һ����n�����֣���ô����ʱ�临�Ӷ���O(nlogn)
     *
     * 	�������n�ǳ���ʱ����Ҫ���������㣬����Ч�ʲ��ߡ�
     */
    public static int NumberOf1Between1AndN(int n) {
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number += NumberOf1(i);
        }
        return number;
    }

    public static int NumberOf1(int n) {
        System.out.println("$" + n);
        int number = 0;
        while (n != 0) {
            System.out.println("@" + n);
            if (n % 10 == 1) {
                number++;
            }
            n = n / 10;
        }
        return number;
    }
}
