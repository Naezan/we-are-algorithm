// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q2623 {
    static String input;
    static String[] inputs;
    static int[] ninputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n+1];

        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            for (int j=1; j<k; j++) {
                int from = Integer.parseInt(line[j]);
                int to = Integer.parseInt(line[j+1]);
                graph.get(from).add(to);
                degree[to]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i=1; i< n+1; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);

            for (int neighbor : graph.get(curr)) {
                degree[neighbor]--;
                if (degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (order.size()==n) {
            for (int singer : order) {
                System.out.println(singer);
            }
        } else {
            System.out.println(0);
        }
    }
}
