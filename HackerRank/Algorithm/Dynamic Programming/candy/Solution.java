import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer n = Integer.parseInt(br.readLine());
            ArrayList<Long> sums = new ArrayList<>();
            long[] candies = new long[n];
            long[] rank = new long[n];

            for(int i = 0; i < n; i++) {
                candies[i] = 1;
                rank[i] = Long.parseLong(br.readLine());
            }

            for(int i = 0; i < n - 1; i++) {
                if(rank[i+1] > rank[i]) {
                    candies[i+1] = candies[i] + 1;
                }
            }

            for(int i = n-2; i >= 0; i--) {
                if(rank[i] > rank[i+1]) {
                    candies[i] = Math.max(candies[i], candies[i+1] + 1);
                }
            }

            long count = 0;
            for(long x: candies) {
                count += x;
            }
            System.out.println(count);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}