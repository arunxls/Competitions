import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for (int t = 0; t < test_cases; t++) {
                String[] params = br.readLine().split(" ");
                Long b = new Long(params[0]);
                Long w = new Long(params[1]);

                params = br.readLine().split(" ");
                Long x = new Long(params[0]);
                Long y = new Long(params[1]);
                Long z = new Long(params[2]);

                System.out.println(b*(Math.min(x, y+z)) + w*(Math.min(y, x+z)));

            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}