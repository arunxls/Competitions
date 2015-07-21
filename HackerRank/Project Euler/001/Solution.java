import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            BigInteger a = BigInteger.valueOf(new Integer(3).intValue());
            BigInteger b = BigInteger.valueOf(new Integer(5).intValue());
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                BigInteger n = BigInteger.valueOf(new Integer(Integer.parseInt(br.readLine())).intValue());
                n = n.subtract(BigInteger.valueOf(new Integer(1)));

                BigInteger count = BigInteger.valueOf(new Integer(0));
                BigInteger combined = a.multiply(b);

                BigInteger combined_sum = find_sum(n.divide(combined), combined);
                BigInteger a_sum = find_sum(n.divide(a), a);
                BigInteger b_sum = find_sum(n.divide(b), b);

                count = a_sum.add(b_sum).subtract(combined_sum);

                // System.out.println(combined_sum);
                // System.out.println(a_sum);
                // System.out.println(b_sum);
                // System.out.println(n.divide(b));

                System.out.println(count);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static BigInteger find_sum(BigInteger num, BigInteger elem) {
        BigInteger two = BigInteger.valueOf(new Integer(2));
        BigInteger one = BigInteger.valueOf(new Integer(1));

        BigInteger a = num.subtract(one);
        BigInteger b = a.multiply(elem);
        BigInteger c = two.multiply(elem);
        BigInteger d = c.add(b);
        BigInteger e = num.multiply(d);
        BigInteger f = e.divide(two);

        return f;
    }
}