// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q2056 {
    static String input;
    static String[] inputs;
    static int[] ninputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] timeReq = new int[n+1];
        int[] totalTime = new int[n + 1];
        int[] preProcesses = new int[n+1];
        ArrayList<ArrayList<Integer>> postProcesses = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            postProcesses.add( new ArrayList<>());
        }

        for (int i=1; i<n+1; i++) {
            inputs = br.readLine().split(" ");
            timeReq[i] = Integer.parseInt(inputs[0]);
            preProcesses[i] = Integer.parseInt(inputs[1]);

            for (int j=2; j<inputs.length; j++) {
                int preProcess = Integer.parseInt(inputs[j]);
                postProcesses.get(preProcess).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<n+1; i++) {
            if (preProcesses[i] == 0) {
                queue.offer(i);
                totalTime[i] = timeReq[i];
            }
        }

        while (!queue.isEmpty()) {
            int currProcess = queue.poll();

            for (int postProcess: postProcesses.get(currProcess)){
                preProcesses[postProcess]--;
                totalTime[postProcess] = Math.max(totalTime[postProcess], totalTime[currProcess] + timeReq[postProcess]);

                if (preProcesses[postProcess] == 0) {
                    queue.add(postProcess);
                }
            }
        }
        int ans = 0;
        for (int i=1; i<n+1; i++) {
            ans = Math.max(ans, totalTime[i]);
        }
        System.out.println(ans);
    }
}
