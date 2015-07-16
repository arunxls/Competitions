import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

public class Solution {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer testcases = Integer.parseInt(br.readLine());
            for (int i = 0; i < testcases; i++) {
                char[] s = br.readLine().toCharArray();

                Integer size = s.length;

                Boolean flag = false;
                for (int j = 1; j < size; j++) {
                    if (Math.abs(s[j] - s[j-1]) != Math.abs(s[size - j] - s[size - j - 1])) {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    System.out.println("Not Funny");
                } else {
                    System.out.println("Funny");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}