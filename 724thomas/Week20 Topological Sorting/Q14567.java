// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q14567 {
    static String input;
    static String[] inputs;
    static int[] ninputs;

    static ArrayList<Integer> prev;
    static ArrayList<Integer> curr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ninputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = ninputs[0], m = ninputs[1];
        Map<Integer, Set<Integer>> courses = new HashMap<>();
        int[] preCourses = new int[n+1];

        for (int i=0; i<m; i++){
            ninputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int pre = ninputs[0], post = ninputs[1];
            courses.putIfAbsent(pre, new HashSet<>());
            courses.get(pre).add(post);
            preCourses[post]++;
        }

        prev = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (preCourses[i+1] == 0) prev.add(i+1);
        }
        int[] ans = new int[n];

        int semester = 1;
        while (!prev.isEmpty()) {
            curr = new ArrayList<>();
            for (int course : prev) {
                ans[course-1] = semester;
                if (!courses.containsKey(course)) continue;
                for (int postCourse : courses.getOrDefault(course, Collections.emptySet())) {
                    preCourses[postCourse]--;
                    if (preCourses[postCourse] == 0) {
                        curr.add(postCourse);
                    }
                }
            }
            prev.clear();
            prev.addAll(curr);
            semester++;
        }
        StringBuilder sb = new StringBuilder();
        for (int num:ans){
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}
