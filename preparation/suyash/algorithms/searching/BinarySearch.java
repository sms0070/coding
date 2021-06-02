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
        int position = binary_searcher(numList, searchValue, 0, numList.size() - 1, -1);

        if (position == -1) {
            System.out.println(searchValue + " not found");
        } else {
            System.out.println(searchValue + " found at position " + position);
        }
    }

    private static int binary_searcher(List<Integer> numList, int searchValue, int l, int r, int pos) {


        if (l > r) return pos;
        if (numList.get((r + l) / 2) == searchValue) {
            pos = (r + l) / 2;
            return pos;
        } else if (numList.get((r + l) / 2) < searchValue) {
            return binary_searcher(numList, searchValue, (r + l) / 2 + 1, r, pos);
        } else {
            return binary_searcher(numList, searchValue, l, ((r + l) / 2) - 1, pos);
        }

    }
}
