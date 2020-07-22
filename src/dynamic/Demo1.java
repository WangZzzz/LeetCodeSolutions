package dynamic;

import util.CommonUtils;

import java.util.Arrays;

/**
 * Created by WangZ on 2020-07-22.
 * 题目：求一个数列中最大连续子序列的和。
 * 状态定义：Fk是第k项前的最大序列和，求F1～FN中最大值。
 * <p>
 * Fk=max{Fk-1+Ak,Ak}
 * Fk是前k项的和，Ak是第k项的值
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = CommonUtils.createTestArray(4);
//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(arr));
        System.out.println(solution(arr, 0, arr.length - 1));
    }

    public static int solution(int[] arr, int l, int r) {
        if (r - l == 1) {
            return arr[r - l];
        }
        if (r - l == 2) {
            int tmp = arr[l] + arr[l + 1];
            int max = arr[l];
            if (arr[l + 1] > max) {
                max = arr[l + 1];
            }
            if (tmp > max) {
                max = tmp;
            }
            return max;
        }
        if (r - l == 3) {
            int tmp1 = arr[l] + arr[l + 1];
            int tmp2 = arr[l + 1] + arr[l + 2];
            int tmp3 = arr[l] + arr[l + 2];
            int tmp4 = arr[l] + arr[l + 1] + arr[l + 2];
            int max = arr[l];

            if (arr[l + 1] > max) {
                max = arr[l + 1];
            }
            if (arr[l + 2] > max) {
                max = arr[l + 2];
            }
            if (tmp1 > max) {
                max = tmp1;
            }
            if (tmp2 > max) {
                max = tmp2;
            }
            if (tmp3 > max) {
                max = tmp3;
            }
            if (tmp4 > max) {
                max = tmp4;
            }
            return max;
        }
        return Math.max(solution(arr, l + 1, r - 1), arr[r]);
    }
}
