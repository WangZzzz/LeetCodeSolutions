package old.Offer;

/**
 * @author WangZ
 * ������24�������������ĺ���������� ��140ҳ
 * ��Ŀ������һ���������飬�жϸ������ǲ���ĳ�����������ĺ��������Ľ�����Ƿ���true���񷵻�false
 * ˼·�����ڵ�϶������һ����Ȼ��������ұ������ҵ���һ���ȸ��ڵ���ֵ����ǰ���ֵ��Ϊ��������ֵ�������ֵ��
 * ֻ�ܱȸ��ڵ�С�������ܱȸ��ڵ��
 */
public class VerifySquenceOfBSTDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(VerifySquenceOfBST(arr1, arr1.length));

        int[] arr2 = {7, 4, 6, 5};
        System.out.println(VerifySquenceOfBST(arr2, arr2.length));
    }

    public static boolean VerifySquenceOfBST(int[] sequence, int length) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        //���ڵ���Զ�����һ�����
        int root = sequence[length - 1];

        //�ڶ������������������Ľ��С�ڸ��ڵ�
        int i = 0;
        for (i = 0; i < length - 1; i++) {
            if (sequence[i] > root) {
                //�ҵ��˵�һ���ȸ��ڵ���ֵ�����Ϊ��������ֵ
                break;
            }
        }

        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                //�ҵ��˵�һ���ȸ��ڵ���ֵ����ô�����Ҳ��ֵ��Ӧ�ö��ȸ��ڵ��
                return false;
            }
        }
        //�ݹ�����ж��������ǲ��Ƕ�������ֵ
        boolean left = true;
        if (i > 0)
            left = VerifySquenceOfBST(sequence, i);
        boolean right = true;
        if (i < length - 1)
            //�Ҳ೤�ȣ�length - (i + 1)
            right = VerifySquenceOfBST(sequence, length - (i + 1));

        return left && right;
    }

}
