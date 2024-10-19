// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q14938 {
    static String input;
    static String[] inputs;
    static int[] ninputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        input = br.readLine();
//        inputs = br.readLine().split(" ");
        ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = ninputs[0], m = ninputs[1], r = ninputs[2];
        int[] items = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] graph = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i=0; i<r; i++) {
            ninputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = ninputs[0]-1, b = ninputs[1]-1, l = ninputs[2];
            graph[a][b] = l;
            graph[b][a] = l;
        }

        for (int mid = 0; mid< n; mid++) {
            for (int start = 0; start<n; start++) {
                for (int end=0; end<n; end++) {
                    if (graph[start][end] > graph[start][mid] + graph[mid][end] && graph[start][mid] != Integer.MAX_VALUE && graph[mid][end] != Integer.MAX_VALUE){
                        graph[start][end] = graph[start][mid] + graph[mid][end];
                    }
                }
            }
        }
        int ans = 0;
        for (int start=0; start<n; start++) {
            int cmax = items[start];
            for (int end=0; end<n; end++) {
                if (start==end || graph[start][end] == Integer.MAX_VALUE) continue;
                if (graph[start][end] <= m){
                    cmax += items[end];
                }
            }
            ans = Math.max(ans, cmax);
//            System.out.println(cmax);
        }
//        for (var a:graph){
//            System.out.println(Arrays.toString(a));
//        }
        System.out.println(ans);
    }
}
