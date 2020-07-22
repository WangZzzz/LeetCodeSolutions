package old.Offer;

/**
 * @author WangZ
 * ������31����������������� 171ҳ
 * ��Ŀ������һ���������飬������������Ҳ�и�����������һ�����������Ķ�������������һ�������飬������������
 * �ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)
 */
public class FindGreatestSumOfSubArrayDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }

    public static int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int sum = 0;
        int max = 0;
        //���͵����߽�
        int Border = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            //������굱ǰֵ֮�󣬻����統ǰֵ����ôsum������Ϊ��ǰֵ
            if (sum < nums[i]) {
                sum = nums[i];
            }
            //ʹ��һ��������¼���ֵ�����sum��max��˵�������µ����ֵ
            if (sum > max) {
                max = sum;
            }

            if (max > Border) {
                max = Border;
            }
        }
        return max;
    }

}
