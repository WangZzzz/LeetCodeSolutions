package old.Offer;

/*
 * 	��90ҳ
 * 	������11��ʵ�ֺ���double Power(double base, int exponent),��base��exponent�η���
 * 	����ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ�������
 */
public class PowerDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Power2(5, 32));
    }

    /*
     * ���ֽⷨû�п��ǵ�����Ϊ0��ָ��С��0����������ϸ�
     */
    public static double Power(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }

    /*
     * ��ֿ��Ǹ����������ָ���Ǹ���ʱ����Ҫ��ָ��ȡ����ֵ��Ȼ����η���������
     * 	��ʱ�����������0���ͻ���0�ĵ�������������Եÿ��ǵ�
     */
    public static double Power2(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            //��ʱ��������0��ָ���Ǹ�����
            throw new RuntimeException("Invalid Input");
        }

        int absExponent = exponent < 0 ? (-exponent) : exponent;//ȡָ���ľ���ֵ
        double result = PowerWithUnsignedExponent2(base, absExponent);

        if (exponent < 0) {
            return 1.0 / result;
        }
        return result;
    }

    public static double PowerWithUnsignedExponent(double base, int exponent) {
        //���溯���ڲ����õķ����� ȡָ���ľ���ֵ����η�
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }

    /*
     * ������ڱ�ʾС��ʱ������float,double��������ֱ����==ȥ�ж��Ƿ����һ����
     * 	�ж�����С���Ƿ���ȣ�ֻ���ж�����֮��ľ���ֵ�ǲ�����һ����С�ķ�Χ�ڣ����
     * 	����С������С���Ϳ�����Ϊ�������
     */
    public static boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        else {
            return false;
        }
    }

    /*
     * 	ȫ���ָ�Ч�Ľⷨ�����磺��һ������32�η�����ǰ���PowerWithUnsignedExponent�У�
     * 	������Ҫ��31�γ˷���
     * 	���Կ��ǻ�һ��˼·������ֻ��Ҫ��16�η��Ļ�������ƽ���Ϳ����ˣ�
     * 	16�η�����8�η���ƽ����8�η������Ĵη���ƽ������ˣ������¹�ʽ��
     * 	a^n = a^(n/2) * a^(n/2) nΪż��
     * 	    = a^((n-1)/2) * a((n-1)/2) * a nΪ����
     */

    public static double PowerWithUnsignedExponent2(double base, int exponent) {
        if (exponent == 0) {//����
            return 1;
        }

        if (exponent == 1) { //����
            return base;
        }
        //exponent >>> 1 ��ʾ exponent = exponent / 2��ʹ��λ����Ч�ʸ�
        double result = PowerWithUnsignedExponent2(base, exponent >>> 1);
        result = result * result;//�˷�
        if ((exponent & 0x1) == 1) {//˵��exponentһֱ��2�������1�������������ݹ�ʽ�����ٳ���base
            result = result * base;//����û��ʹ��%�����жϣ�����ʹ��λ�������Ч�ʸ�
        }

        return result;
    }
}
