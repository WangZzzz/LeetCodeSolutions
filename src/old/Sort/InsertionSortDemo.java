package old.Sort;

/*
 * ֱ�Ӳ������򣺽���ߵ���Ϊ�Ѿ��ź���ģ����ұߵ����β���
 *
 * ����˼�룺��Ҫ�����һ�����У�����ǰ��(n-1) [n>=2] �����Ѿ�����
 *	��˳��ģ�����Ҫ�ѵ�n�����嵽ǰ����������У�ʹ����n����
 *		Ҳ���ź�˳��ġ���˷���ѭ����ֱ��ȫ���ź�˳��
 *	�ص㣺1.������������У�ֱ�Ӳ����������
 *			2.��¼�������ٵ��������У�ֱ�ӳ���Ҳ�ܿ�
 *		O(n^2)
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {40, 2, 1, 43, 3, 65, 0, -1, 58, 3, 42, 4};
        insertionSort2(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void insertionSort(int[] data) {
        if (data == null || data.length < 0) {
            return;
        }
        int n = data.length;
        int i, j, k, tmp;
        ;
        for (i = 1; i < n; i++) {
            //Ѱ�Ҳ���λ��
            for (j = 0; j <= i - 1; j++) {
                if (data[j] > data[i])
                    break;
            }
            tmp = data[i];
            //��������ƶ�����λ��j����data[i]���ֵ
            for (k = i - 1; k >= j; k--) {
                data[k + 1] = data[k];
            }
            data[j] = tmp;
        }
    }

    /*
     * ���ֲ������򣬰�Ѱ�Ҳ���λ�úͺ���Ԫ��һ������ˡ�
     */
    public static void insertionSort2(int[] data) {
        if (data == null || data.length < 0) {
            return;
        }
        int n = data.length;
        int i, j, k, tmp;
        ;
        for (i = 1; i < n; i++) {
            tmp = data[i];
            //Ѱ�Ҳ���λ��
            for (j = i - 1; j >= 0 && tmp < data[j]; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = tmp;
        }
    }
}
