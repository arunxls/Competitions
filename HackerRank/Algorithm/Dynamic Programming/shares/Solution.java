import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t=0; t< test_cases; t++) {
                Integer n = Integer.parseInt(br.readLine());
                Long[] stock = new Long[n];
                Long[] max = new Long[n];

                String[] s = br.readLine().split(" ");
                for(int i = 0; i < n; i++) {
                    stock[i] = Long.parseLong(s[i]);
                }

                max[n-1] = stock[n-1];
                for(int i = n-2; i >=0; i--) {
                    if(stock[i] > max[i+1]) {
                        max[i] = stock[i];
                    } else {
                        max[i] = max[i+1];
                    }
                }

                long price = 0;
                for(int i = 0; i < n; i++) {
                    if(stock[i] < max[i]) {
                        price += max[i] - stock[i];
                    }
                }

                System.out.println(price);

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}