package old.Offer;

/**
 * @author WangZ
 * ������41����ΪS����������VS��Ϊs������������
 * ��Ŀһ������һ����������������һ������s���������в�����������ʹ�����ǵĺ͸պ���s������ж�����ֵĺ͵���s���������һ�Լ���
 * ������������{1,2,4,7,11,15}������15������4+11=15��������4��11
 * ˼·��
 * ����һ�����������й̶�һ�����֣����ж������е������n-1�����������ĺ��ǲ��ǵ���s��O(n^2)��ʱ�临�Ӷ�
 * ��������ͷβ˫ָ�룬�������s����ô�ƶ�βָ����ǰ�����С��s����ô�ƶ�ͷָ�����,���������м�ɨ�裬ʱ�临�Ӷ�ΪO(n)
 * <p>
 * ��Ŀ��������һ������s����ӡ�����к�Ϊs�������������У����ٺ���������������������15������1+2+3+4+5=4+5+6=7+9=15��
 * ���Խ����ӡ��3����������1~5,4~6��7~8
 */
public class FindNumbersWithSumDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1, 2, 4, 7, 11, 15};
        FindNumbersWithSum(nums, 15);
        FindContinousSequence(9);
    }

    public static void FindNumbersWithSum(int[] nums, int s) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == s) {
                System.out.println("������Ϊ�� " + nums[i] + "��" + nums[j]);
                return;
            } else if ((nums[i] + nums[j]) > s) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("û���ҵ����");
    }

    //��Ŀ����˼·������Ŀһ��ͬ������ָ�룬small��big��small����ָ��1��bigָ��2��Ȼ���ж�small+big��ֵ���������s����ôbig�����ƶ�1��
    //���С��s����ôsmall�����ƶ���ͬʱ����Ҫ��֤����Ҫ���������֣�����һֱ����small����1+s)/2Ϊֹ,��Ϊ����������������ô��������ӣ�
    //�ĺͿ϶�����s
    public static void FindContinousSequence(int sum) {
        if (sum < 3) {
            //��������1+2����ô����ֵ��С��3
            return;
        }

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        //С���ɣ�ʹ��currentSum���浱ǰ��͵�ֵ������Ҫ�ظ����
        int currentSum = small + big;
        while (small < big) {
            if (currentSum == sum) {
                PrintSequence(small, big);
            }
            //����ǰ�ʹ���sumʱ������smallС��(s+1)/2
            while (currentSum > sum && small < middle) {
                //��ʱ����Ҫ��small�����ƶ������Ҵ�currentSum�м�ȥ
                currentSum = currentSum - small;
                small++;
                if (currentSum == sum) {
                    PrintSequence(small, big);
                }
            }
            big++;
            currentSum = currentSum + big;
        }
    }

    //��ӡ����
    public static void PrintSequence(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
