package old.Other;

/**
 * @author WangZ
 * ����С������
 */
public class GetMinCommonMultipleDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(GetMaxCommonDivide(15, 12));
        System.out.println(GetMinCommonMultiple(8, 6));
    }

    public static int GetMinCommonMultiple(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        return (m * n) / GetMaxCommonDivide(m, n);
    }

    /*
     * �����Լ����ŷ������㷨
     */
    public static int GetMaxCommonDivide(int m, int n) {
        if (m == 0 || n == 0) {
            throw new RuntimeException();
        }
        int larger;
        int smaller;

        if (m > n) {
            larger = m;
            smaller = n;
        } else {
            larger = n;
            smaller = m;
        }

        if (larger % smaller == 0) {
            return smaller;
        }

        return GetMaxCommonDivide(smaller, larger % smaller);
    }

}
