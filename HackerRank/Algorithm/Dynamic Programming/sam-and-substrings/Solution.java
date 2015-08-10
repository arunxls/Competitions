import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String string = br.readLine();
            String[] str = string.split("");

            Long mod = 1000000007L;

            Long sum = Long.parseLong(str[0]);
            Long last;
            for(int i = 1; i < str.length; i++) {
                last = (((i+1)*Long.parseLong(str[i]) +  sum*10))%mod;
                sum += last;
            }

            System.out.println(sum);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}