package old.Offer;

import java.awt.geom.RectangularShape;
import java.util.function.IntPredicate;

/**
 * @author WangZ
 * ������36�������е������ 189ҳ
 * ��Ŀ���������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԣ�����һ�����飬�����������е�����Ե�������
 * ���磺{7,5,6,4},һ������5������ԣ�(7,6)��(7,5)��(7,4)��(6,4)��(5,4)
 */
public class InversePairsDemo {

    private static int cnt = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 0, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        System.out.println(InversePairs(nums));
        System.out.println(InversePairs2(nums));

        int[] nums2 = {49, 38, 65, 97, 76, 13, 27, 0, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        //���ù鲢����
        MergeSort(nums2, 0, nums2.length - 1);
        System.out.println(cnt);
    }

    /*
     * ����һ��
     * 	O(n^2)��������ɨ�����飬ÿɨ�赽һ�������͸������ÿһ�����ֱȽϣ��ж��ǲ��������
     * 	�����㷨̫����������Ҫ��
     */
    public static int InversePairs(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int i = 0, j = 0;
        int cnt = 0;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /*
     * 	�������ù鲢����
     */
    public static int InversePairs2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        int count = InversePairsCore(nums, copy, 0, nums.length - 1);

        return count;
    }

    private static int InversePairsCore(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }

        int length = (end - start) / 2;//length��һ��ĳ���

        int left = InversePairsCore(copy, nums, start, start + length);
        int right = InversePairsCore(copy, nums, start + length + 1, end);

        //i��ʼ��Ϊǰ������һ�����ֵ��±�
        int i = start + length;

        //j��ʼ��Ϊ���ε�һ�����ֵ��±�
        int j = end;
        //�����������
        //��Ϊ������ԣ��Ƚ�������>�����Դ�ĩβ��ʼ�Ƚϸ�ֵ
        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (nums[i] > nums[j]) {
                copy[indexCopy--] = nums[i--];
                count += j - start - length;//start + length Ϊj�ǰ��������ʼλ������
            } else {
                copy[indexCopy--] = nums[j--];
            }
        }

        for (; i >= start; --i) {
            copy[indexCopy--] = nums[i];
        }

        for (; j >= start + length + 1; j--) {
            copy[indexCopy--] = nums[j];
        }

        return left + right + count;
    }

    //���������������ĸĽ��ͣ������׿������鲢����

    public static void MergeSort(int[] data, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            //���
            MergeSort(data, low, mid);
            //�ұ�
            MergeSort(data, mid + 1, high);
//			//�������������ҹ鲢
            Merge(data, low, mid, high);
        }
    }

    public static void Merge(int[] data, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = mid;//��ָ�룬����low~mid��ߵ�����
        int j = high;//��ָ�룬����mid+1~high��ߵ�����
        int k = tmp.length - 1;//����������

        while (i >= low && j >= mid + 1) {
            if (data[i] > data[j]) {
                tmp[k--] = data[i--];
                cnt += j - mid;//��ʱ��˵��������ԣ���������Ե�����Ϊj - mid
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
