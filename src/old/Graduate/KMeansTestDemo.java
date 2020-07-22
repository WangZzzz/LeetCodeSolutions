package old.Graduate;

public class KMeansTestDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        float[] p = {1, 2, 3, 5, 6, 7, 9, 10, 11, 100, 150, 200, 1000, 10000};
        int k = 3;
        System.out.println(getData(p, k));
    }


    public static float getData(float[] p, int k) {
        float[][] g;
        g = cluster(p, k);
        int i = 0, max = 0;
        for (i = 1; i < g.length; i++) {
            if (g[i].length > g[i - 1].length) {
                max = i;
            }
        }

        float sum = 0;
        for (int j = 0; j < g[max].length; j++) {
            sum = sum + g[max][j];
        }

        return (sum / (g[max].length));
    }

    /*
     * ���ຯ�����塣
     * ���һά float ���顣ָ��������Ŀ k��
     * �����ݾ۳� k �ࡣ
     */
    public static float[][] cluster(float[] p, int k) {
        // ��ž���ɵľ�������
        float[] c = new float[k];
        // ����¼���ľ�������
        float[] nc = new float[k];
        // ��ŷŻؽ��
        float[][] g;
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
                nc = new float[k];
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
    public static float center(float[] p) {
        return ksum(p) / p.length;
    }

    /*
     * ���� float ������ p �;������� c��
     * ���� c �� p ��Ԫ�ؾ��ࡣ���ض�ά���顣
     * ��Ÿ���Ԫ�ء�
     */
    public static float[][] group(float[] p, float[] c) {
        // �м����������������
        int[] gi = new int[p.length];
        // ����ÿһ��Ԫ�� pi ͬ�������� cj �ľ���
        // pi �� cj �ľ�����С���Ϊ j ��
        for (int i = 0; i < p.length; i++) {
            // ��ž���
            float[] d = new float[c.length];
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
        float[][] g = new float[c.length][];
        // ����ÿ���������ģ�����
        for (int i = 0; i < c.length; i++) {
            // �м��������¼�����ÿһ��Ĵ�С
            int s = 0;
            // ����ÿһ��ĳ���
            for (int j = 0; j < gi.length; j++)
                if (gi[j] == i)
                    s++;
            // �洢ÿһ��ĳ�Ա
            g[i] = new float[s];
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
    public static float distance(float x, float y) {
        return Math.abs(x - y);
    }

    /*
     * ���ظ��� float �����Ԫ��֮�͡�
     */
    public static float ksum(float[] p) {
        float sum = 0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }

    /*
     * ���� float �������飬������Сֵ���±ꡣ
     */
    public static int min(float[] p) {
        int i = 0;
        float m = p[0];
        for (int j = 1; j < p.length; j++) {
            if (p[j] < m) {
                i = j;
                m = p[j];
            }
        }
        return i;
    }

    /*
     * �ж����� float �����Ƿ���ȡ� ����һ���Ҷ�Ӧλ��ֵ��ͬ�����档
     */
    public static boolean equal(float[] a, float[] b) {
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
