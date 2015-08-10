import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                Integer n = Integer.parseInt(br.readLine());
                Long[] b = new Long[n];
                String[] s = br.readLine().split(" ");
                for(int i = 0; i < n; i++) {
                    b[i] = Long.parseLong(s[i]);
                }

                long[][] dp = new long[n][2];
                dp[0][0] = 0L;
                dp[0][1] = 0L;

                for(int i = 1; i < n; i++) {
                    dp[i][0] = Math.max(
                            (dp[i-1][0] + Math.abs(b[i-1] - b[i])),
                            (dp[i-1][1] + Math.abs(b[i] - 1)));
                    dp[i][1] = Math.max(
                            (dp[i-1][0] + Math.abs(b[i-1] - 1)),
                            (dp[i-1][1] + Math.abs(1 - 1)));
                }

                System.out.println(Math.max(dp[n-1][1], dp[n-1][0]));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}