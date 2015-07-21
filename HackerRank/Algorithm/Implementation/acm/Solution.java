import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] params = br.readLine().split(" ");
            Integer n = Integer.parseInt(params[0]);
            Integer m = Integer.parseInt(params[1]);

            String[][] mat = new String[n][m];
            for(int i = 0; i < n; i++) {
                String[] temp = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = temp[j];
                }
            }

            HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
            Integer max = 0;
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    Integer matches = match(mat[i], mat[j]);
                    if(matches > max) {
                        max = matches;
                    }
                    if(!count.containsKey(matches)) {
                        count.put(matches, 0);
                    }
                    count.put(matches, count.get(matches) + 1);
                }
            }

            System.out.println(max);
            System.out.println(count.get(max));

        } catch(Exception e) {
            System.out.print(e);
        }
    }

    public static Integer match(String[] a, String[] b) {
        Integer count = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i].equals("1") || b[i].equals("1")) {
                count++;
            }
        }

        return count;
    }
}