package old.Offer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author WangZ
 * ������30����С��k����		167ҳ
 * ��Ŀ������n���������ҳ�������С��k��������������4��5��1��6��2��7��3��8��8�����֣�����С��k��������1��2��3��4
 */
public class GetLeastNumbersDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] output = new int[k];
        GetLeastNumbers(nums, output, k);
        System.out.println(Arrays.toString(output));

    }

    /*
     * 	˼·������Partition���������������⣬�����������ĵ�k��������������ʹ�ñȵ�k������С���������ֶ�λ���������ߣ�
     * 	�ȵ�k�����ִ���������ֶ�λ��������ұߣ�������������֮��λ����������ߵ�k�����־�����С��k�����֣���k�����ֲ�һ���������
     * 	O(n)��ʱ�临�Ӷ�
     * 	ȱ���ǣ����޸�ԭ����
     */
    public static void GetLeastNumbers(int[] nums, int[] output, int k) {
        if (nums == null || nums.length <= 0 || output == null || k > nums.length || k <= 0) {
            return;
        }

        int l = 0;
        int r = nums.length - 1;
        int index = Partition(nums, l, r);
        while (index != k - 1) {
            if (index > k - 1) {
                //˵����k��ֵ��index����ߣ��������б�Ϊl��index֮��
                r = index - 1;
                index = Partition(nums, l, r);
            } else {
                l = index + 1;
                index = Partition(nums, l, r);
            }
        }

        //��nums��ǰk����ֵ��output
        for (int i = 0; i < k; i++) {
            output[i] = nums[i];
        }
    }

    /*
     * 	�ص㣺O(nlogk)���㷨���ر��ʺϴ���������
     * 	˼·������һ����СΪk�������������洢��С��k�����֣�������ÿ�δ������n�������ж���һ������������������е���������k����
     * 		��ֱ�Ӱ���ζ����������������֮�У��������������k�������ˣ�Ҳ�����������ˣ����ʱ�����ٲ����µ����ֶ�ֻ���滻����
     * 	�����֣��ҳ������е�k�������е����ֵ��Ȼ������δ���������ֺ����ֵ���бȽϣ���������ֵ�����ֵС���������������
     * 	�滻���е����ֵ������������ֵ���ȵ�ǰ���е����ֵ��Ҫ����ô���������������С��k������֮һ�����ǿ������������
     *
     * 	����������֮����Ҫ��3�������飺
     * 	1.��k���������ҵ������
     * 	2.�п��������������ɾ�������
     * 	3.�п���Ҫ����һ���µ�����
     * 	���ʹ�ö�������ʵ�����������������ô��������O(logk)ʱ����ʵ����������������ˣ�����n���������ֶ��ԣ��ܵ�ʱ��Ч�ʾ���
     * 	O(nlogk)
     *
     * 	���ǿ���ѡ���ò�ͬ�Ķ�������ʵ�������������������ÿ�ζ�Ҫ�ҵ�k�������е��������֣��������뵽ʹ�����ѣ��������У�
     * 	���ڵ��ֵ���Ǵ��������������������ֵ�����ǣ�ÿ�����ǿ�����O(1)��ʱ�����ҵ�k�������е����ֵ������ҪO(logk)ʱ�����
     * 	ɾ�����������
     *
     * 	java�����е�TreeSet�ǻ��ں�����ģ����ֲ�����ʱ�临�Ӷ�ΪO(logn),����Ҫ��
     */
    public static void GetLeastNumbers2(int[] nums, TreeSet<Integer> leasetNumbers, int k) {
        leasetNumbers.clear();

        if (nums == null || nums.length <= 0 || k <= 0 || k >= nums.length) {
            return;
        }
        for (int i : nums) {
            if (leasetNumbers.size() < k) {
                leasetNumbers.add(i);
            } else {

            }
        }
    }

    public static int Partition(int[] nums, int l, int r) {
        //���ѡȡһ����
        Random random = new Random();
        int index = random.nextInt(r - l + 1) + l;

        int tmp = nums[l];
        nums[l] = nums[index];
        nums[index] = tmp;

        tmp = nums[l];

        while (l < r) {
            while ((l < r) && (nums[r] >= tmp))
                r--;
            nums[l] = nums[r];
            while ((l < r) && (nums[l] <= tmp))
                l++;
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

}
