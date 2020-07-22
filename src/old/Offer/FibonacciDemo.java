package old.Offer;

/*
 * ������9��쳲���������  73ҳ
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Fibonacci(9));
        System.out.println(Fibonacci2(9));
        System.out.println(climbStairs(9));
        System.out.println(climbStairs2(9));
    }

    /*
     * ���ֽⷨЧ�ʵ��£�����ֺܶ��ظ��Ľڵ�
     */
    public static long Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /*
     * ����ѭ���ķ�ʽ������С�Ŀ�ʼ����
     * 	0 	1 	1 	2 	3 	5 	8 	13 	21 	34
     * 	f1	f2	f
     * 		f1	f2	f
     * 			f1	f2	f
     * 				f1	f2	f
     */
    public static long Fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        long fib1 = 0;
        long fib2 = 1;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }

        return fib;
    }

    /*
     * 	�����⣺һֻ����һ�ο�������һ��̨�ף�Ҳ��������2����
     * ���ʣ�����������n����̨���ܹ��ж���������
     * 	n = 1, 1��
     * 	n = 2, [1,1] [2]  2��
     * 	n = 3, [1,1,1] [1,2] [2,1]  3��
     * 	n = 4, [1,1,1,1] [1,1,2] [1,2,1] [2,1,1] [2,2] 5��
     * 	n = 5, [1,1,1,1,1] [2,2,1] [2,1,2] [1,2,2] [1,1,1,2] [1,1,2,1] [1,2,1,1] [2,1,1,1] 8��
     * 	쳲���������
     */

    public static long climbStairs(int n) {
        int[] result = {1, 2};
        if (n <= 2) {
            return result[n - 1];
        }

        int f1 = result[0];
        int f2 = result[1];
        int f = 0;
        for (int i = 3; i <= n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

    public static long climbStairs2(int n)//�ݹ鷽ʽ,쳲��������У�ֻ�������ڲ�һ��
    {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

