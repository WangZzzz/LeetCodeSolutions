package sort;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = CommonUtils.createTestArray(20);
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int i = start;
        int j = end;

        int key = array[start];

        while (i < j) {
            while (array[j] >= key & i < j) {
                j--;
            }
            array[i] = array[j];

            while (array[i] <= key & i < j) {
                i++;
            }
            array[j] = array[i];

        }
        array[i] = key;
        return i;
    }
}
