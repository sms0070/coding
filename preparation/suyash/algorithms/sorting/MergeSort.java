package suyash.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        mergeSort(array, 0, n - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        //System.out.println("left is "+left+" right is "+right+" middle is "+middle+" merging "+ Arrays.toString(array));

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] array1 = new int[n1];
        int[] array2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            array1[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            array2[i] = array[middle + i + 1];
        }
        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = array1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = array2[j];
            j++;
            k++;
        }

        //System.out.println("merged "+Arrays.toString(array));

    }
}
