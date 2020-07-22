package old.Offer;

import java.util.Arrays;

/*
 *	��102ҳ
 *	������14����������˳��ʹ����λ��ż��ǰ��
 *		��Ŀ������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ��
 *		�����ǰ�벿�֣�����ż��λ������ĺ�벿��
 */
public class ReorderOddEvenDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1};
        ReorderOddEven(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
     * 	˼·��˫ָ�룬һ��ָ����ߣ�һ��ָ���ұߣ����ָ�����ƣ����ҵ�ż��ʱ���ұ�ָ����������
     * 	���ҵ�����ʱ�����н���
     */
    public static void ReorderOddEven(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        //˫ָ��
        int l = 0;
        int r = nums.length - 1;
        /*
         * 	�ж�ż������������ʵ���Ǿ����ж϶����Ƶ����һλ��1����0
         * 	��ˣ����Ժ�0x1����&���㣬�ж��Ƿ�Ϊ0����ȡ����Ҫ��ܶ�
         */
        while (l < r) {
            //�ҵ���ߵ�һ��ż��
            while ((l <= r) && ((nums[l] & 0x1) != 0)) {
                l++;
            }
            //�ҵ��ұߵ�һ������
            while ((l <= r) && ((nums[r] & 0x1) == 0)) {
                r--;
            }

            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
    }
}
