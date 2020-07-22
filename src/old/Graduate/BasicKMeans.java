package old.Graduate;

public class BasicKMeans {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double[] p = {1, 2, 3, 5, 6, 7, 9, 10, 11, 100, 150, 200, 1000, 10000};
        int k = 4;
        double[][] g;
        g = cluster(p, k);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                System.out.print(g[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    /*
     * ���ຯ�����塣
     * ���һά double ���顣ָ��������Ŀ k��
     * �����ݾ۳� k �ࡣ
     */
    public static double[][] cluster(double[] p, int k) {
        // ��ž���ɵľ�������
        double[] c = new double[k];
        // ����¼���ľ�������
        double[] nc = new double[k];
        // ��ŷŻؽ��
        double[][] g;
        // ��ʼ����������
        // ���䷽�������ѡȡ k ��
        // �����в���ǰ k ����Ϊ��������
        // �������ĵ�ѡȡ��Ӱ�����ս��
        for (int i = 0; i < k; i++)
            c[i] = p[i];
        // ѭ�����࣬���¾�������
        // ���������Ĳ���Ϊֹ
        while (true) {
            // ���ݾ������Ľ�Ԫ�ط���
            g = group(p, c);
            // ��������ľ�������
            for (int i = 0; i < g.length; i++) {
                nc[i] = center(g[i]);
            }
            // ����������Ĳ�ͬ
            if (!equal(nc, c)) {
                // Ϊ��һ�ξ���׼��
                c = nc;
                nc = new double[k];
            } else // �������
                break;
        }
        // ���ؾ�����
        return g;
    }

    /*
     * �������ĺ���
     * �򵥵�һά���෵��������ƽ��ֵ
     * ����չ
     */
    public static double center(double[] p) {
        return sum(p) / p.length;
    }

    /*
     * ���� double ������ p �;������� c��
     * ���� c �� p ��Ԫ�ؾ��ࡣ���ض�ά���顣
     * ��Ÿ���Ԫ�ء�
     */
    public static double[][] group(double[] p, double[] c) {
        // �м����������������
        int[] gi = new int[p.length];
        // ����ÿһ��Ԫ�� pi ͬ�������� cj �ľ���
        // pi �� cj �ľ�����С���Ϊ j ��
        for (int i = 0; i < p.length; i++) {
            // ��ž���
            double[] d = new double[c.length];
            // ���㵽ÿ���������ĵľ���
            for (int j = 0; j < c.length; j++) {
                d[j] = distance(p[i], c[j]);
            }
            // �ҳ���С����
            int ci = min(d);
            // ���������һ��
            gi[i] = ci;
        }
        // ��ŷ�����
        double[][] g = new double[c.length][];
        // ����ÿ���������ģ�����
        for (int i = 0; i < c.length; i++) {
            // �м��������¼�����ÿһ��Ĵ�С
            int s = 0;
            // ����ÿһ��ĳ���
            for (int j = 0; j < gi.length; j++)
                if (gi[j] == i)
                    s++;
            // �洢ÿһ��ĳ�Ա
            g[i] = new double[s];
            s = 0;
            // ���ݷ����ǽ���Ԫ�ع�λ
            for (int j = 0; j < gi.length; j++)
                if (gi[j] == i) {
                    g[i][s] = p[j];
                    s++;
                }
        }
        // ���ط�����
        return g;
    }

    /*
     * ����������֮��ľ��룬 ���������򵥵�һάŷ�Ͼ��룬 ����չ��
     */
    public static double distance(double x, double y) {
        return Math.abs(x - y);
    }

    /*
     * ���ظ��� double �����Ԫ��֮�͡�
     */
    public static double sum(double[] p) {
        double sum = 0.0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }

    /*
     * ���� double �������飬������Сֵ���±ꡣ
     */
    public static int min(double[] p) {
        int i = 0;
        double m = p[0];
        for (int j = 1; j < p.length; j++) {
            if (p[j] < m) {
                i = j;
                m = p[j];
            }
        }
        return i;
    }

    /*
     * �ж����� double �����Ƿ���ȡ� ����һ���Ҷ�Ӧλ��ֵ��ͬ�����档
     */
    public static boolean equal(double[] a, double[] b) {
        if (a.length != b.length)
            return false;
        else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i])
                    return false;
            }
        }
        return true;
    }
}
