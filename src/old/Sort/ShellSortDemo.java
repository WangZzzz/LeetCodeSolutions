package old.Sort;

/*
 * ϣ�����򣬲�������ĸĽ��ͣ�ʵ�ʾ��Ƿ����������
 * �÷����Ļ���˼���ǣ��Ƚ���������Ԫ�����зָ������
 * �������У������ĳ������������Ԫ����ɵģ��ֱ����ֱ�Ӳ�������
 * Ȼ���������������ٽ������򣬴����������е�Ԫ�ػ������������㹻С��ʱ��
 * �ٶ�ȫ��Ԫ�ؽ���һ��ֱ�Ӳ���������Ϊֱ�Ӳ���������Ԫ�ػ�����
 * �������£��ӽ�����������Ч���Ǻܸߵģ����ϣ��������ʱ��Ч��
 * �ϻ�ܸ�
 *
 * ʱ�临�Ӷȣ�O(n^2)��O(nlog2(n))֮��,�ؼ����Ӷ�O(1)
 * 	O(n^1.5)
 */
public class ShellSortDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {49, 38, 65, 97, 76, 13, 27, 0, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        shellSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void shellSort(int[] data) {
        if (data == null || data.length <= 0) {
            return;
        }
        int n = data.length;
        int gap, i, j, k, tmp;
        for (gap = n / 2; gap > 0; gap = gap / 2) {
            for (i = 0; i < gap; i++) {
                insertionSort(data, gap, i);
            }
        }
    }

    /*
     * ϣ�����򣬷ֿ�֮��ʹ�õĻ��ǲ�������ֻ����������������1��
     */
    private static void insertionSort(int[] data, int gap, int m) {
        if (data == null || data.length < 0) {
            return;
        }
        int n = data.length;
        int i, j, k, tmp;
        ;
        for (i = m + gap; i < n; i = i + gap) {
            tmp = data[i];
            //Ѱ�Ҳ���λ��
            for (j = i - gap; j >= 0 && tmp < data[j]; j = j - gap) {
                data[j + gap] = data[j];
            }
            data[j + gap] = tmp;
        }
    }
}
