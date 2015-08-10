import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] params = br.readLine().split(" ");
            Integer n = Integer.parseInt(params[0]);
            Integer m = Integer.parseInt(params[1]);

            for(String s: br.readLine().split(" ")) {
                coins.add(Integer.parseInt(s));
            }

            Collections.sort(coins, Collections.reverseOrder());

            long one = 1;
            long zero = 0;
            Long[] matrix = new Long[n+1];
            matrix[0] = one;

            for(int i = m-1; i >= 0; i--) {
                int initial = coins.get(i);
                for(int j = 1; j < n+1; j++) {
                    if(matrix[j] == null) {
                        matrix[j] = zero;
                    }
                    if(j >= initial) {
                        matrix[j] = matrix[j] + matrix[j-initial];
                    }
                }
            }

            System.out.println(matrix[n]);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}