import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

public class Solution {
    public static void main (String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            char[] s1 = br.readLine().toCharArray();
            char[] s2 = br.readLine().toCharArray();

            HashMap<Character, Integer> h1 = new HashMap<Character, Integer>();
            HashMap<Character, Integer> h2 = new HashMap<Character, Integer>();
            HashSet<Character> all_char = new HashSet<Character>();

            for(int i = 0; i < s1.length; i++) {
                all_char.add(s1[i]);
                if(!h1.containsKey(s1[i])) {
                    h1.put(s1[i], 0);
                }

                h1.put(s1[i], h1.get(s1[i]) + 1);
            }

            for(int i = 0; i < s2.length; i++) {
                all_char.add(s2[i]);
                if(!h2.containsKey(s2[i])) {
                    h2.put(s2[i], 0);
                    }
                h2.put(s2[i], h2.get(s2[i]) + 1);
            }

            int total = 0;
            for (char c: all_char) {
                if(h1.containsKey(c) && h2.containsKey(c)) {
                    total += Math.abs(h1.get(c) - h2.get(c));
                } else if(h1.containsKey(c)) {
                    total += h1.get(c);
                } else if(h2.containsKey(c)) {
                    total += h2.get(c);
                }
            }

            System.out.println(total);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
