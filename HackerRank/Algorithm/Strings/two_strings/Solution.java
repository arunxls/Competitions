import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                char[] c1 = br.readLine().toCharArray();
                char[] c2 = br.readLine().toCharArray();

                HashSet<Character> charSet = new HashSet<Character>();
                for (int j = 0; j < c1.length; j++) {
                    charSet.add(c1[j]);
                }

                Boolean flag = false;
                for (int j = 0; j < c2.length; j++) {
                    if(charSet.contains(c2[j])) {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}