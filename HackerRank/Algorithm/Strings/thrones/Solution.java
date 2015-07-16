import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            char[] s = br.readLine().toCharArray();
            HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
            for (Character c : s) {
                if (chars.containsKey(c)) {
                    chars.put(c, chars.get(c) + 1);
                } else {
                    chars.put(c, 1);
                }
            }

            int num_of_odd = 0;
            for (Character c: chars.keySet()) {
                // System.out.println(c + " => " + chars.get(c));
                if (chars.get(c)%2 != 0) {
                    num_of_odd++;
                }
            }

            if(num_of_odd > 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}