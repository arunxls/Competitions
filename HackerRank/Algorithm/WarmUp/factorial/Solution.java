import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer n = Integer.parseInt(br.readLine());
            BigInteger num = BigInteger.valueOf(n.intValue());
            BigInteger ans = BigInteger.valueOf((new Integer(1)).intValue());
            BigInteger sub = BigInteger.valueOf((new Integer(1)).intValue());
            BigInteger zero = BigInteger.valueOf((new Integer(0)).intValue());
            while(num.compareTo(zero) > 0) {
                ans = ans.multiply(num);
                num = num.subtract(sub);
            }

            System.out.println(ans);


        } catch (Exception e) {
            System.err.println(e);
        }

    }
}