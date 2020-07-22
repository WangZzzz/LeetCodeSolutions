package old.Offer;

/***
 * @author WangZ
 * 	������29�������г��ִ�������һ������� 163ҳ
 * 		��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֣����磬����һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * 		��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2
 */

import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public class MoreThanHalfNumDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
/*		int[] data = {49,38,65,97,76,13,27,0,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		quickSort(data,0,data.length-1);
		System.out.println(Arrays.toString(data));*/
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum(nums));
        System.out.println(MoreThanHalfNum2(nums));
    }

    /**
     * ����һ�����ÿ�������
     * ˼·�����������������ô����֮��λ�������м������һ�������Ǹ����ִ����������鳤��һ�������
     * ���������Parationÿ�ζ��ܷ��� mid�������Կ��Կ����ص�mid�ǲ���������м䣬������򷵻�����
     * �¼����Ӷ�O(n)
     * ����Paration�㷨��ÿ�η���һ��index����indexǰ���������index������С��index�����������index��
     */
    public static int MoreThanHalfNum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }
        int length = nums.length;
        int middle = length >> 1;//���ǳ���2
        int start = 0;
        int end = length - 1;
        int index = Partition(nums, start, end);
        while (index != middle) {
            if (index > middle) {
                //˵��middle��index�����
                end = index - 1;
                index = Partition(nums, start, end);
            } else {
                start = index + 1;
                index = Partition(nums, start, end);
            }
        }

        int result = nums[middle];
        /*
         * 	�ж������λ�����ֵĴ����Ƿ�������鳤�ȵ�һ��
         */
        int cnt = 0;
        for (int i : nums) {
            if (i == nums[middle])
                cnt++;
        }
        if (cnt <= (length >> 1)) {
            result = 0;
        }

        return result;

    }

    public static int Partition(int[] nums, int start, int end) {
        /*
         * ���ѡȡһ����
         */
        if (nums == null || nums.length <= 0 || start < 0 || end >= nums.length) {
            throw new RuntimeException("�������");
        }
        Random random = new Random();
        int ran = random.nextInt(end - start + 1) + start;
        int tmp = nums[start];
        nums[start] = nums[ran];
        nums[ran] = tmp;

        tmp = nums[start];
        while (start < end) {
            while ((start < end) && (nums[end] >= tmp))
                end--;
            nums[start] = nums[end];
            while ((start < end) && (nums[start] <= tmp))
                start++;
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }

    /*
     * 	�����������������ص��ҳ�O(n)���㷨
     * 	��������ʱ����������ֵ��һ���������е�һ�����֣�һ���Ǵ���������������һ�����ֵ�ʱ�������һ�����ֺ�֮ǰ�����������ͬ��
     * 	�����+1�������һ�����ֺ�֮ǰ��������ֲ�ͬ���������1���������Ϊ0������Ҫ������һ�����֣�������������Ϊ1��
     * 	��������Ҫ�ҵ����ֵĳ��ֵĴ����������������ֳ��ֵĴ���֮�ͻ�Ҫ�࣬��ôҪ�ҵ����ֿ϶������һ�ΰѴ�������Ϊ1��Ӧ������
     */

    public static int MoreThanHalfNum2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }

        int result = nums[0];
        int times = 1;
        for (int i = 0; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        /*
         * 	�ж������λ�����ֵĴ����Ƿ�������鳤�ȵ�һ��
         */
        int cnt = 0;
        for (int i : nums) {
            if (i == result)
                cnt++;
        }
        if (cnt <= (nums.length >> 1)) {
            result = 0;
        }

        return result;

    }

    /*
     * 	����
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = Partition(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }
}
