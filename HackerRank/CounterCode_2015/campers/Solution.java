import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] params = br.readLine().split(" ");
            Long n = Long.parseLong(params[0]);
            Long k = Long.parseLong(params[1]);

            String[] snipers = br.readLine().split(" ");
            Long[] nums = new Long[n.intValue()+2];
            for (String s: snipers) {
                nums[Integer.parseInt(s)] = (long) 0;
                nums[Integer.parseInt(s)-1] = (long) 0;
                nums[Integer.parseInt(s)+1] = (long) 0;
            }
            Long count = (long) 0;
            for(long i = 1; i <= n; i++) {
                if(nums[(int) i] == null) {
                    count++;
                    nums[(int)i+1] = (long) 0;
                }
            }


            System.out.println(count + k);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}