package suyash.algorithms.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        if (args.length == 0) {
            for (int i = 0; i < 10; i++) {
                numList.add((int) (Math.random()));
                Collections.sort(numList);
            }
        } else {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                numList.add(in.nextInt());
            }
        }
        int searchValue = in.nextInt();
        int position = binary_searcher(numList, searchValue);

        if (position == -1) {
            System.out.println(searchValue + " not found");
        } else {
            System.out.println(searchValue + " found at position " + position);
        }
    }

    private static int binary_searcher(List<Integer> numList, int searchValue) {
        int position = -1;

        return position;
    }
}
