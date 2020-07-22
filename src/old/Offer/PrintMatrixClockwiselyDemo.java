package old.Offer;

/*
 * 	������20��˳ʱ���ӡ���� ��127ҳ
 * 	��Ŀ������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 */
public class PrintMatrixClockwiselyDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        PrintMatrixClockwisely(arr);
    }

    @SuppressWarnings("unused")
    public static void PrintMatrixClockwisely(int[][] nums) {
//		System.out.println(nums[1].length);
        if (nums == null && nums.length <= 0) {
            //�������
            return;
        }
        int columns = nums[0].length - 1;
        int rows = nums.length - 1;
        int startX = 0;
        int startY = 0;
        while (startX <= rows && startY <= columns) {
            PrintMatrixInCircle(nums, startX, startY, rows, columns);
            startX++;
            startY++;
            rows--;
            columns--;
        }
    }

    public static void PrintMatrixInCircle(int[][] nums, int startX, int startY, int rows, int columns) {

    }

}
