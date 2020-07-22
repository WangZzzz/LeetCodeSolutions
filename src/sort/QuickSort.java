package sort;

import util.CommonUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = CommonUtils.createTestArray(20);
        System.out.println(Arrays.toString(array));
        quickSort2(array, 0, array.length - 1);
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
            while (i < j & array[j] >= key) {
                j--;
            }
            if (i < j) {
                //a[j] 挖了个坑 填到 a[i], a[j]多了个坑
                array[i] = array[j];
                i++;
            }

            while (i < j & array[i] <= key) {
                i++;
            }
            if (i < j) {
                //填上a[j]的坑
                array[j] = array[i];
                j--;
            }
        }
        array[i] = key;
        return i;
    }

    public static void quickSort2(int[] arr, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int key = arr[i];
            while (i < j) {
                while (i < j & arr[j] > key) {
                    j--;
                }

                arr[i] = arr[j];

                while (i < j & arr[i] < key) {
                    i++;
                }

                arr[j] = arr[i];
            }
            arr[i] = key;
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }
    }
}
