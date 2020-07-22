package old.Offer;

/**
 * @author WangZ
 * �����⣺34 ���� 182ҳ
 * ��Ŀ�����ǰ�ֻ��������2��3��5��������������Ugly Number)���󰴴�С�����˳��ĵ�1500�����������磬6��8���ǳ�����
 * ����14���ǣ���Ϊ����������7��ϰ���ϰ�1������һ������
 */
public class GetUglyNumberDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(GetUglyNumber(1500));
    }

    /**
     * ��ֱ�۵������� һ�������жϣ�������������Ҫ�ж�ÿ�����ǲ��ǳ������ٶȱȽ���
     */
    public static int GetUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int cnt = 0;
        int i = 1;
        while (true) {
            if (isUgly(i)) {
                System.out.println(i);
                cnt++;
            }
            if (cnt == index) {
                break;
            }
            i++;
        }

        return i;

    }

    public static boolean isUgly(int number) {
        boolean isUgly = false;
        //��һ�����ǲ��ǳ���������ǳ��������2��3��5ȡ�࣬�϶�����ܵ�1
        int tmp = number;
        while (number % 2 == 0) {
            number = number / 2;
        }

        while (number % 3 == 0) {
            number = number / 3;
        }

        while (number % 5 == 0) {
            number = number / 5;
        }

        if (number == 1) {
            isUgly = true;
//			System.out.println(tmp);
        }


        return isUgly;

    }

}
