package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Q20437 {
    public static void check(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> firstIndexMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            firstIndexMap.putIfAbsent(c, i);

            if (countMap.get(c) == k) {
                int start = firstIndexMap.get(c);
                int end = i;
                int length = end - start + 1;
                minLength = Math.min(minLength, length);
                maxLength = Math.max(maxLength, length);

                for (int j = start + 1; j < s.length(); j++) {
                    if (s.charAt(j) == c) {
                        firstIndexMap.put(c, j);
                        break;
                    }
                }
                countMap.put(c, countMap.get(c) - 1);
            }
        }

        if (minLength == Integer.MAX_VALUE || maxLength == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minLength + " " + maxLength);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            check(s, k);
        }
    }
}
