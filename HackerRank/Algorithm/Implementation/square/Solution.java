import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for (int t = 0; t < test_cases; t++) {
                String[] params = br.readLine().split(" ");
                Integer lower = Integer.parseInt(params[0]);
                Integer upper = Integer.parseInt(params[1]);

                double sqrt_u = Math.sqrt(upper);
                double c_sqrt_u = Math.ceil(sqrt_u);

                Integer count = (int) c_sqrt_u - (int) Math.ceil(Math.sqrt(lower));
                if(c_sqrt_u == sqrt_u) {
                    count++;
                }

                System.out.println(count);
            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}