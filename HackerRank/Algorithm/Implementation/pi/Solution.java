import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pi = "31415926535897932384626433833";

        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for (int t = 0; t < test_cases; t++) {
                String[] input = br.readLine().split(" ");

                StringBuffer test = new StringBuffer();
                for(String s: input) {
                    test.append(Integer.toString(s.length()));
                }

                String test_string = test.toString();

                if(pi.startsWith(test_string)) {
                    System.out.println("It's a pi song.");
                } else {
                    System.out.println("It's not a pi song.");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}