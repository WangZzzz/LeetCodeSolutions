package old.Offer;


/*
 * ������8����ת�������С����
 */
public class MinNumDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = {1, 0, 1, 1, 1};
        System.out.println(method(data));
    }

    public static int method(int[] data) {
        if (data == null || data.length <= 0) {
            throw new RuntimeException("�����������");
        }
        int l = 0;
        int r = data.length - 1;
        int mid = l;
        while (data[l] >= data[r]) {//������ĵ�һ��Ԫ��С�����һ��Ԫ��ʱ��˵�����鱾����������,���һ��Ԫ�ؾ�����С�ģ�ֱ�ӷ���
            if (r - l == 1) {
                mid = r;
                break;
            }
            mid = (l + r) / 2;
            if (data[l] == data[mid] && data[mid] == data[r]) {
                //��3��λ���������ʱ���˲���ֻ��˳�����{0,1,1,1,1}��������ת����
                //{1,0,1,1,1},{1,1,1,0,1},
                return MinInOrder(data, l, r);
            }
            if (data[mid] >= data[l]) {
                l = mid;
            } else if (data[mid] <= data[r]) {
                r = mid;
            }
        }
        return data[mid];
    }

    public static int MinInOrder(int[] data, int l, int r) {
        int min = l;
        for (int i = l + 1; i <= r; i++) {
            if (data[i] < data[min]) {
                min = i;
            }
        }
        return data[min];
    }
}
