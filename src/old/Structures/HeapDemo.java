package old.Structures;

import java.util.Arrays;

import javax.naming.InitialContext;

//��С��
public class HeapDemo {
    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 0, 78};
        for (int i = (nums.length / 2 - 1); i >= 0; i--) {
            Heapfy(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));

        //������ ע��ʹ����С��������ǵݼ����飬Ҫ�õ��������飬����ʹ�����ѡ� n * logn
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            Heapfy(nums, 0, i);
        }
        System.out.println(Arrays.toString(nums));

    }


    //�ڶ���ɾ�����ݣ������һ����㻻������㣬���¶ѻ�
    public static void delteNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        swap(nums, 0, nums.length - 1);
        Heapfy(nums, 0, nums.length - 1);//���¶ѻ�
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //С���ѻ�
    public static void Heapfy(int[] nums, int i, int n) {
        if (nums == null || nums.length <= 0 || i >= n) {
            return;
        }
        int tmp = nums[i];
        int j = 2 * i + 1;
        while (j < n) {
            //�ҵ����ҽ���н�С�Ľ��
            if (j + 1 < n && nums[j + 1] < nums[j]) {
                j++;
            }

            if (tmp <= nums[j]) {
                //��������²���Ҫ�������Ѿ�������С�ѵ�����
                break;
            }

            nums[i] = nums[j];
            i = j;
            j = 2 * i + 1;
        }

        nums[i] = tmp;//�Ѿ���j����i�ˣ������Ǹ�i��tmp��ֵ
    }
}
