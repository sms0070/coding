package suyash.interview;

import java.util.PriorityQueue;
import java.util.Queue;

public class PaytmInterview {

    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};

        int totalDaysToRot = totalDaysRotten(matrix, 3, 4);
        System.out.println(totalDaysToRot);
    }

    // put visited =1 whenever a neighbour is 0
    // queue all the neighbors
    // 1 1 0 1
    // 1 1 1 1
    // 1 1 1 1

    public static int totalDaysRotten(int[][] matrix, int m, int n) {

        int[][] visited = new int[m][n];
        Queue bfsQueue = new PriorityQueue();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    bfsQueue.add(i + " " + j);
                }
            }
        }
        int currentCount = runBFS(visited, m, n, bfsQueue);
        return currentCount;
    }

    public static int runBFS(int[][] visited, int m, int n, Queue bfsQueue) {


        int dayCount = 0;

        while (!bfsQueue.isEmpty()) {
            Queue tempQueue = new PriorityQueue();
            String coord = (String) bfsQueue.remove();
            String[] s = coord.split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            visited[i][j] = 1;

            if (i < m - 1 && visited[i + 1][j] == 0) {
                tempQueue.add((i + 1) + " " + j);
            }
            if (j < n - 1 && visited[i][j + 1] == 0) {
                tempQueue.add(i + " " + (j + 1));
            }
            if (i > 1 && visited[i - 1][j] == 0) {
                tempQueue.add(i - 1 + " " + j);
            }
            if (j > 1 && visited[i][j - 1] == 0) {
                tempQueue.add(i + " " + (j - 1));
            }

            if (bfsQueue.isEmpty()) {
                bfsQueue.addAll(tempQueue);
                dayCount++;
            }
        }
        return dayCount;

    }


}
