import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer n = Integer.parseInt(br.readLine());
            Integer[] array = new Integer[n];
            for(int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }

            Integer[] d = new Integer[n];

            d[0] = 1;
            for(int i = 1; i < n; i++) {
                if()
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}