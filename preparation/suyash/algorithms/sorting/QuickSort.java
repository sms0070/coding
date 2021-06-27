package suyash.algorithms.sorting;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        array = quickSort(array, 0, n - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }


        return array;
    }

    private static int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);

    }

    private static void swap(int[] array, int a, int b) {

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
