import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long zero = (long) 0;
        Long one  = (long) 1;
        Long two  = (long) 2;
        Long four = (long) 4;

        try {
            Long test_cases = new Long(br.readLine());
            Long counter = (long) 0;
            while(counter.compareTo(test_cases) < 0) {
                Long n = new Long(br.readLine());
                Long sum = zero;
                Long result = two;

                Long a = two;
                Long b = zero;

                while(result.compareTo(n) < 1) {
                    sum = sum + result;
                    result = (four*a) + b;
                    b = a;
                    a = result;

                }

                System.out.println(sum);
                counter = counter + one;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}