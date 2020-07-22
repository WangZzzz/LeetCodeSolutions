package old.Other;

import java.util.ArrayList;
import java.util.List;

//����㷨      
//�������˼·�ǿ�һ�����飬���±��ʾ1��m����������Ԫ�ص�ֵΪ1��ʾ���±�      
//���������ѡ�У�Ϊ0��ûѡ�С�        
//���ȳ�ʼ����������ǰn��Ԫ����1����ʾ��һ�����Ϊǰn������        
//Ȼ�������ɨ������Ԫ��ֵ�ġ�10����ϣ��ҵ���һ����10����Ϻ����Ϊ      
//��01����ϣ�ͬʱ������ߵ����С�1��ȫ���ƶ������������ˡ�        
//����һ����1���ƶ��������m-n��λ�ã���n����1��ȫ���ƶ������Ҷ�ʱ���͵�      
//�������һ����ϡ�        
//������5��ѡ3����ϣ�        
//1   1   1   0   0   //1,2,3        
//1   1   0   1   0   //1,2,4        
//1   0   1   1   0   //1,3,4        
//0   1   1   1   0   //2,3,4        
//1   1   0   0   1   //1,2,5        
//1   0   1   0   1   //1,3,5        
//0   1   1   0   1   //2,3,5        
//1   0   0   1   1   //1,4,5        
//0   1   0   1   1   //2,4,5        
//0   0   1   1   1   //3,4,5      
public class TestDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        List l = Test(nums, 3);
        print(l);
    }

    public static List Test(int[] nums, int m) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int n = nums.length;
        if (m > n) {
            throw new RuntimeException("��������a��ֻ��" + n + "��Ԫ�ء�" + m + "����" + 2 + "!!!");
        }

        List result = new ArrayList();

        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            bs[i] = 0;
        }
        //��ʼ��   
        for (int i = 0; i < m; i++) {
            bs[i] = 1;
        }
        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;
        //�����ҵ���һ��10��ϣ�Ȼ����01��ͬʱ��������е�1�ƶ�������������   
        do {
            sum = 0;
            pos = 0;
            tempFlag = true;
            result.add(print(bs, nums, m));

            for (int i = 0; i < n - 1; i++) {
                if (bs[i] == 1 && bs[i + 1] == 0) {
                    bs[i] = 0;
                    bs[i + 1] = 1;
                    pos = i;
                    break;
                }
            }
            //����ߵ�1ȫ���ƶ�������������   

            for (int i = 0; i < pos; i++) {
                if (bs[i] == 1) {
                    sum++;
                }
            }
            for (int i = 0; i < pos; i++) {
                if (i < sum) {
                    bs[i] = 1;
                } else {
                    bs[i] = 0;
                }
            }

            //����Ƿ����е�1���ƶ��������ұ�   
            for (int i = n - m; i < n; i++) {
                if (bs[i] == 0) {
                    tempFlag = false;
                    break;
                }
            }
            if (tempFlag == false) {
                flag = true;
            } else {
                flag = false;
            }

        } while (flag);
        result.add(print(bs, nums, m));

        return result;
    }

    private static int[] print(int[] bs, int[] a, int m) {
        int[] result = new int[m];
        int pos = 0;
        for (int i = 0; i < bs.length; i++) {
            if (bs[i] == 1) {
                result[pos] = a[i];
                pos++;
            }
        }
        return result;
    }

    private static void print(List l) {
        for (int i = 0; i < l.size(); i++) {
            int[] a = (int[]) l.get(i);
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
}
