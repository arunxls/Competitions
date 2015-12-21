import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                Integer size = Integer.parseInt(br.readLine());
                int[] array = new int[size];
                String[] elems = br.readLine().split(" ");
                for(int j = 0; j < size; j++) {
                    array[j] = Integer.parseInt(elems[j]);
                }
                int max_so_far = 0;
                int max_ending_here = 0;
                int max_sum = 0;
                int min = -Integer.MIN_VALUE;
                for(int current : array) {
                    max_ending_here = Math.max(0, max_ending_here + current);
                    max_so_far = Math.max(max_so_far, max_ending_here);
                    min = Math.max(current, min);
                    if(current > 0) {
                        max_sum += current;
                    }
                }
                if(max_so_far == 0) {
                    System.out.println(min + " " + min);
                } else {
                    System.out.println(max_so_far + " " + max_sum);
                }
            }
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}