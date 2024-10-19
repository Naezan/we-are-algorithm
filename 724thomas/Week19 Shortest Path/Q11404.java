// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q11404 {
    static String input;
    static String[] inputs;
    static int[] ninputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=0; i<m; i++) {
            ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int start = ninputs[0]-1, end = ninputs[1]-1, cost = ninputs[2];
            graph[start][end] = Math.min(graph[start][end], cost);
        }

        for (int mid = 0; mid<n; mid++) {
            for (int start = 0; start<n; start++) {
                for (int end = 0; end<n; end ++ ) {
                    if (graph[start][end] > graph[start][mid] + graph[mid][end] && graph[start][mid] != Integer.MAX_VALUE && graph[mid][end] != Integer.MAX_VALUE) {
                        graph[start][end] = graph[start][mid] + graph[mid][end];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
