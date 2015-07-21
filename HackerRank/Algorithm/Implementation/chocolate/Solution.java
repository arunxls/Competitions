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
            for(int t = 0; t < test_cases; t++) {
                String[] params = br.readLine().split(" ");
                Integer n = Integer.parseInt(params[0]);
                Integer c = Integer.parseInt(params[1]);
                Integer m = Integer.parseInt(params[2]);

                Integer count = n/c;

                Integer existing_wrappers = count;


                while (existing_wrappers/m != 0) {
                    Integer existing_chocolates = existing_wrappers/m;
                    existing_wrappers -= existing_chocolates*m;

                    count += existing_chocolates;
                    existing_wrappers += existing_chocolates;

                }

                System.out.println(count);

            }
        } catch (Exception e) {

        }
    }
}