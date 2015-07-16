import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                char[] s = br.readLine().toCharArray();

                char lastseen = 'C';
                int count = 0;
                for (char c : s) {
                    if(lastseen == c) {
                        count++;
                    }
                    lastseen = c;
                }

                System.out.println(count);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}