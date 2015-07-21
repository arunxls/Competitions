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
            for(int t = 0; t < test_cases; t++) {
                String int_s = br.readLine();
                Integer value = Integer.parseInt(int_s);
                char[] s = int_s.toCharArray();
                ArrayList<Integer> input = new ArrayList<Integer>();
                for(char c : s) {
                    if(c != '0') {
                        input.add(Character.getNumericValue(c));
                    }
                }

                HashSet<Integer> seen = new HashSet<Integer>();
                Integer count = 0;
                for(int i : input) {
                    if(!seen.containsKey(i)) {
                        seen.add(i);
                        if(value%i == 0) {
                            count++;
                        }
                    }
                }

                System.out.println(count);
            }
        } catch(Exception e) {

        }
    }
}