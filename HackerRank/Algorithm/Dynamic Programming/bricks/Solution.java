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
                String[] b = br.readLine().split(" ");
                Integer[] bricks = new Integer[n+1];
                for(int i = 0; i < n; i++) {
                    bricks[n-i] = Integer.parseInt(b[i]);
                }

                Long[] dp = new Long[n+1];
                Long[] psum = new Long[n+1];
                psum[0] = (long) 0;
                for(int i = 1; i <= n; i++) {
                    psum[i] = psum[i-1] + bricks[i];
                }

                dp[0] = (long)0;
                dp[1] = psum[1];
                dp[2] = psum[2];
                dp[3] = psum[3];

                for(int i = 4; i <= n; i++) {
                    dp[i] = psum[i-1] - dp[i-1] + bricks[i];
                    dp[i] = Math.max(dp[i], psum[i-2] - dp[i-2] + bricks[i] + bricks[i-1]);
                    dp[i] = Math.max(dp[i], psum[i-3] - dp[i-3] + bricks[i] + bricks[i-1] + bricks[i-2]);
                }

                System.out.println(dp[n]);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}