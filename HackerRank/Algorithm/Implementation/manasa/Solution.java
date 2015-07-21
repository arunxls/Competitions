import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for (int t = 0; t < test_cases; t++) {
                Integer n = Integer.parseInt(br.readLine());
                Integer a = Integer.parseInt(br.readLine());
                Integer b = Integer.parseInt(br.readLine());

                Integer min = Math.min(a,b);
                Integer max = Math.max(a,b);

                HashSet<Integer> ans = new HashSet<Integer>();


                Integer last = (n-1) * min;
                Integer diff = (max-min);
                while(n > 0) {
                    ans.add(last);
                    last += diff;
                    n--;
                }

                ArrayList<Integer> sorted = new ArrayList<Integer>(ans);
                Collections.sort(sorted);

                for(Integer x: sorted) {
                    System.out.print(x + " ");
                }
                System.out.println("");
            }
        } catch(Exception e) {

        }
    }
}