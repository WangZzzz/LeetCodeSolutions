package old.Offer;

/**
 * @author WangZ
 * ������38�����������������г��ֵĴ��� 204ҳ
 * ��Ŀ��ͳ��һ�����������������г��ֵĴ���������������������{1,2,3,3,3,3,4,5}������3������3����������г�����4�Σ�
 * ������4
 * �����۰�����ҵ����������еĵ�һ��k�����һ��k����������ô����֪���ж��ٸ�������
 * ���ֲ��ҵ�ʱ�临�Ӷ�O(logn)��GetFirstK��GetLastK�����ö��ֲ��ҷ��������в���һ���Ϻ�Ҫ������֣����ǵ�ʱ�临�Ӷȶ���O(logn),
 * ��ˣ�����㷨���ܵ�ʱ�临�Ӷ���O(logn)
 */
public class GetNumberOfKDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(nums, 3));
    }

    public static int GetNumberOfK(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int cnt = 0;
        int firstIndex = GetFirstK(nums, k, 0, nums.length - 1);
        System.out.println(firstIndex);
        int lastIndex = GetLastK(nums, k, 0, nums.length - 1);
        System.out.println(lastIndex);
        if (firstIndex > -1 && lastIndex > -1) {
            cnt = lastIndex - firstIndex + 1;
        }

        return cnt;

    }

    /*
     * 	�ҵ���һ��k�����ö��ֲ��ң�����м������Ϊk��������ǰһ�����ֲ���k����˵��������־��ǵ�һk�������һ��k��ǰ���
     */
    public static int GetFirstK(int[] nums, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = nums[middleIndex];

        if (middleData == k) {
            //˵����ʱmiddleIndex����k���ǵ�һ��k
            /*
             * 	���������һ���м������Ϊk��ǰһ�����ֲ���k���ڶ��������index�Ѿ����˵�һλ
             */
            if ((middleIndex > 0 && nums[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                //˵����һ��k�����
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            //˵��k�����
            end = middleIndex - 1;
        } else {
            //˵��k���ұ�
            start = middleIndex + 1;
        }

        return GetFirstK(nums, k, start, end);
    }

    //ͬ���õ����һ��k������
    public static int GetLastK(int[] nums, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = nums[middleIndex];

        if (middleData == k) {
            //˵����ʱmiddleIndex����k�������һ��k
            /*
             * 	���������һ���м������Ϊk�Һ�һ�����ֲ���k���ڶ��������index�Ѿ��������һλ
             */
            if ((middleIndex < nums.length - 1 && nums[middleIndex + 1] != k) || middleIndex == nums.length - 1) {
                return middleIndex;
            } else {
                //˵�����һ��k���ұ�
                start = middleIndex + 1;
            }
        } else {
            if (middleData > k) {
                end = middleIndex - 1;
            } else {
                start = middleIndex + 1;
            }
        }

        return GetLastK(nums, k, start, end);
    }

}
