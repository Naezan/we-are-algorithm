// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Q10159 {
    static String input;
    static String[] inputs;
    static int[] ninputs;
    static boolean[] visited;
    public static int counting(int start, Map<Integer, ArrayList<Integer>> map, int n){
        visited = new boolean[n+1];
        return dfs(start, map);
    }

    public static int dfs(int node, Map<Integer, ArrayList<Integer>> map) {
        visited[node] = true;
        int count = 0;
        for (int next: map.getOrDefault(node, new ArrayList<>())) {
            if (visited[next]) continue;
            count += 1 + dfs(next, map);
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, ArrayList<Integer>> heavierThan = new HashMap<>();
        Map<Integer, ArrayList<Integer>> lighterThan = new HashMap<>();
        int n = Integer.parseInt(br.readLine()); // <= 100
        int m = Integer.parseInt(br.readLine()); // <= 2000

        for (int i=0; i<m; i++) {
            inputs = br.readLine().split(" ");
            int heavier = Integer.parseInt(inputs[0]);
            int lighter = Integer.parseInt(inputs[1]);
            heavierThan.putIfAbsent(heavier, new ArrayList<>());
            lighterThan.putIfAbsent(lighter, new ArrayList<>());
            heavierThan.get(heavier).add(lighter);
            lighterThan.get(lighter).add(heavier);
        }

        for (int i=1; i<n+1; i++) {
            int hCount = counting(i, heavierThan, n);
            int lCount = counting(i, lighterThan, n);
            int ans = n - (hCount + lCount + 1);
            System.out.println(ans);
        }
    }
}
