package old.Sort;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/*
 * �鲢���򣺹鲢��Merge�������ǽ����������������ϣ������ϲ���һ���µ������
 * ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ�����������С�
 *	ʱ�临�Ӷ�����ΪO(n)
 *	1.�ϲ������������飺
 *		����ǳ��򵥣�ֻҪ�ӱȽ϶������еĵ�һ������˭С����ȡ˭��ȡ�˺���ڶ�Ӧ������ɾ���������
 *		Ȼ���ٽ��бȽϣ����������Ϊ�գ���ֱ�ӽ���һ�����е���������ȡ�����ɡ�
 *	2.�鲢���򣺽�����ֳɶ���A��B�������������ڵ����ݶ�������ģ���ô�Ϳ��Ժܷ���Ľ���������ݽ�������
 *		�����������������������ˣ�
 *		���Խ�A��B������ٷֳɶ��顣�������ƣ����ֳ�����С��ֻ��һ������ʱ��������Ϊ���С�������Ѿ��ﵽ������
 *		Ȼ���ٺϲ����ڵĶ���С��Ϳ����ˡ�����ͨ���ȵݹ�ķֽ����У��ٺϲ����о�����˹鲢����
 *
 *	�鲢�����Ч���ǱȽϸߵģ������г�ΪN�������зֿ���С����һ��ҪlogN����ÿ������һ���ϲ��������еĹ��̣�
 *	ʱ�临�Ӷȿ��Լ�ΪO(N)����һ��ΪO(N*logN)����Ϊ�鲢����ÿ�ζ��������ڵ������н��в��������Թ鲢������O(N*logN)
 *	�ļ������򷽷����������򣬹鲢����ϣ�����򣬶�����Ҳ��Ч�ʱȽϸߵġ�
 *
 *	O(nLogn)
 */
public class MergeSortDemo {

    private static int count = 0;
    private static int flag = 0;

    public static void main(String[] args) {
        int[] data = {49, 38, 65, 97, 76, 13, 27, 0, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        System.out.println(data.length);
        int[] data2 = {49, 38, 65, 97, 76, 13, 27, 0, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        mergeSort2(data2, 0, data2.length - 1);
        System.out.println(Arrays.toString(data2));
        System.out.println(count);
    }

    /*
     * 	�ϲ������������У�data[low~mid],data[mid~high]
     */
    public static void merge(int[] data, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;//��ָ�룬����low~mid��ߵ�����
        int j = mid + 1;//��ָ�룬����mid+1~high��ߵ�����
        int k = 0;//����������

        while (i <= mid && j <= high) {
            if (data[i] < data[j]) {
                tmp[k++] = data[i++];

            } else {
                tmp[k++] = data[j++];
            }
        }

        //�����ʣ������Ƶ���ʱ���飬��ߺ��ұ߲�����ͬʱ����ʣ������飬ֻ������һ����
        while (i <= mid) {
            tmp[k++] = data[i++];
        }

        //���ұ�ʣ������Ƶ���ʱ����
        while (j <= high) {
            tmp[k++] = data[j++];
        }

        //����ʱ�����ֵ����ԭ���飬ע�⣬���Ǵ�0��ʼ���Ǵ�low��ʼ
        for (int m = 0; m < tmp.length; m++) {
            data[m + low] = tmp[m];
        }
    }

    /*
     * ͨ���ȵݹ�ķֽ����У��ٺϲ����о�����˹鲢����
     * ��ֱ���ֽ��ֻ��һ����ʱ�����Ǿ���Ϊ�����������
     */
    public static void mergeSort(int[] data, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            //���
            mergeSort(data, low, mid);
            //�ұ�
            mergeSort(data, mid + 1, high);
//			//�������������ҹ鲢
            merge(data, low, mid, high);
        }
    }

    public static void mergeSort2(int[] data, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            //���
            mergeSort2(data, low, mid);
            //�ұ�
            mergeSort2(data, mid + 1, high);
//			//�������������ҹ鲢
            merge2(data, low, mid, high);
        }
    }

    public static void merge2(int[] data, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = mid;//��ָ�룬����low~mid��ߵ�����
        int j = high;//��ָ�룬����mid+1~high��ߵ�����
        int k = tmp.length - 1;//����������

        while (i >= low && j >= mid + 1) {
            if (data[i] > data[j]) {
                tmp[k--] = data[i--];
                count += j - mid;
            } else {
                tmp[k--] = data[j--];
            }
        }

        //�����ʣ������Ƶ���ʱ���飬��ߺ��ұ߲�����ͬʱ����ʣ������飬ֻ������һ����
        while (i >= low) {
            tmp[k--] = data[i--];
        }

        //���ұ�ʣ������Ƶ���ʱ����
        while (j >= mid + 1) {
            tmp[k--] = data[j--];
        }

        //����ʱ�����ֵ����ԭ���飬ע�⣬���Ǵ�0��ʼ���Ǵ�low��ʼ
        for (int m = 0; m < tmp.length; m++) {
            data[m + low] = tmp[m];
        }
    }
}

