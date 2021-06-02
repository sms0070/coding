package suyash.algorithms.searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        List<Long> numList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        if (args.length == 0) {
            for (int i = 0; i < 10; i++) {
                numList.add((long) (Math.random()));
            }
        } else {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                numList.add(in.nextLong());
            }
        }
        Long searchValue = in.nextLong();
        int position = linearly_search(numList, searchValue);
        if (position == -1) {
            System.out.println(searchValue + " not found");
        } else {
            System.out.println(searchValue + " found at position " + position);
        }

    }

    private static int linearly_search(List<Long> numList, Long searchValue) {
        int position = -1;
        int counter = 0;
        for (long num : numList) {
            counter++;
            if (num == searchValue) {
                position = counter;
                break;
            }
        }
        return position;
    }
}
