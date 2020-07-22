package old.Offer;

/**
 * @author WangZ
 * ������40��������ֻ����һ�ε����� 211ҳ
 * ��Ŀ��һ�����������������������֮�⣬���������ֶ����������Σ���Щ�����ҳ�������ֻ����һ�ε����֣�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)
 * ������������{2,4,3,6,3,2,5,5} ����Ϊֻ��4��6����������ֻ������һ�Σ����������ֶ����������Σ��������4��6
 * ������Ŀ��һ��������ֻ��һ�����ֳ�����һ�Ρ���ʹ���������ʣ�0����κ�����Ϊ�Ǹ�������������ͬ������������������Ϊ0��
 * ���Խ�����Ԫ�ش�ͷ��β����������㣬���Ľ�������Ǹ�ֻ����һ�ε�����
 * ˼·�����ǰ�ԭ����ֳ��������飬�ֱ����������㣬��ô��λ��֣�
 * �ȶ�ԭ�������һ��������㣬�õ�һ����������ݽ���ĵ�nΪ�ǲ���1���������ҵ����ұߵĵ�һ��1������ԭ����ֳ������֣���������һ�ε����϶��������������飬
 * ͬʱ����ͬ�����϶�������ͬһ������
 */
public class FindNumsAppearOnceDemo {

    public static int tmp1 = 0;
    public static int tmp2 = 0;

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        FindNumsAppearOnce(nums);
        System.out.println(tmp1);
        System.out.println(tmp2);
    }

    public static void FindNumsAppearOnce(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        int indexOf1 = FindFirstBitIs1(result);
        //������������ֱַ���������㣬�������������һ�ε���
        for (int i = 0; i < nums.length; i++) {
            if (isBit1(nums[i], indexOf1)) {
                tmp1 = tmp1 ^ nums[i];
            } else {
                tmp2 = tmp2 ^ nums[i];
            }
        }

    }

    //�ҵ�������������еĵ�һ��1
    public static int FindFirstBitIs1(int num) {
        int indexBit = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            indexBit++;
        }
        System.out.println("index : " + indexBit);
        return indexBit;
    }

    //�ж�һ�����ֵĵ�nλ�����������ǲ���1
    public static boolean isBit1(int num, int n) {
/*		int index = 0;
		boolean res = false;
		while(true){
			if(index == n){
				if((n & 1) == 1){
					res = true;
				}
				break;
			}else{
				index++;
				n = n >> 1;
			}
		}
		return res;*/

        //ֱ��λ��nλ
        num = num >> n;
        return (num & 1) == 1;
    }
}
