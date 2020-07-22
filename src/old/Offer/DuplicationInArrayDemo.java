package old.Offer;

import java.util.Arrays;

/**
 * @author WangZ
 * ������51���������ظ������� 261ҳ
 * ��Ŀ����һ������Ϊn������������������ֶ���0��n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ����ǲ�֪���м��������ظ��ˣ�Ҳ��֪��ÿ������
 * �ظ��˼��Σ����ҳ�����������һ���ظ������֣��������볤��Ϊ7������{2,3,1,0,2,5,3},��ô��Ӧ��������ظ�������2����3
 * <p>
 * ˼·�������뵽���ǽ�������������������������ҵ��ظ��������Ǻ����׵ģ�ֻ��Ҫ��ͷ��βɨ������������Ϳ����ˣ�O(nlogn)
 * ������������ǲ�����Ҫ���
 * ��ô�����Կ��ǽ�ÿ�����ֻ���������ȷ������λ���ϣ���ɨ���0��Ԫ�أ��������0��������2����ô�ͽ���������2λ�õ�Ԫ�رȽϣ������ȣ�
 * ��ô���ҵ���һ���ظ������飬�������ȣ���ô�Ͱ�����2�������ֺ�����0��������2��������ͣ���ظ���ȥ
 */
public class DuplicationInArrayDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        DuplicationInArray(nums);
    }

    /*
     * 	ѭ��һ�μ���,O(n)��ʱ�临�Ӷȣ�û�ж��ö���ռ䣬O(1)�Ŀռ临�Ӷ�
     */
    public static void DuplicationInArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        int i = 0;
        for (i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    System.out.println("�ظ���" + nums[i]);
                    swap(nums, i, nums[i]);
                    break;//������λ��������ͬʱ�������break�����Ϊ��ѭ��
                } else {
                    swap(nums, i, nums[i]);
                }

            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
