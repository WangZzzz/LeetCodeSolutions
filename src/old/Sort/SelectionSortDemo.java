package old.Sort;

public class SelectionSortDemo {
	/*
	 * ��Ҫ�����һ�����У�ѡ������һ���������һ��λ�õ���������
			Ȼ����ʣ�µ����������������뵹���ڶ���λ�õ���������
			���ѭ�����ڶ������͵�һ�����Ƚ�Ϊֹ
				O(n^2)
	 */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {40, 2, 1, 43, 3, 65, 0, -1, 58, 3, 42, 4};
        selectionSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void selectionSort(int[] data) {
        if (data == null || data.length < 0) {
            return;
        }
        int n = data.length;
        int max = 0;
        int i, j;
        for (i = 0; i < n; i++) {
            max = 0;
            for (j = 1; j < n - i; j++) {
                if (data[j] > data[max]) {
                    max = j;
                }
            }
            swap(data, n - 1 - i, max);//����ÿ�˵����һ��Ԫ�غ�max
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
