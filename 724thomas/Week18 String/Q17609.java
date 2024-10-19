Q20437// https://www.acmicpc.net/problem/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q17609 {
    static String input;
    static String[] inputs;
    static int[] nimputs;

    public static boolean checkPalindrome(String s){
        int length = s.length();
        for (int i=0; i<length/2; i++){
            if (s.charAt(i) != s.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }

    public static int checkPalindromeLevel(String s) {
        int lp = 0, rp = s.length() - 1;
        while (lp < rp) {
            if (s.charAt(lp) == s.charAt(rp)) {
                lp++;
                rp--;
            } else {
                if (checkPalindrome(s.substring(lp + 1, rp + 1)) || checkPalindrome(s.substring(lp, rp))) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            input = br.readLine().trim();
            if (checkPalindrome(input)) {
                System.out.println(0);
            } else {
                System.out.println(checkPalindromeLevel(input));
            }
        }
    }
}
