import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                Long num = Long.parseLong(br.readLine());
                Long sub = 4294967295L;

                System.out.println(sub-num);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}