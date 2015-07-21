import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Long min = Long.parseLong(br.readLine());
            Long max = Long.parseLong(br.readLine());

            Integer count = 0;
            for(Long i = min; i <= max; i++) {
                Integer length = i.toString().length();
                Long i2 = i*i;
                String square = i2.toString();
                Integer length2 = square.length();
                // if(length2 == 2*length || length2 == (2*length + 1)) {
                    // System.out.println(square);
                    // System.out.println(square.substring(0, length-1));
                    // System.out.println(square.substring(length, length2));

                    Integer left = 0;
                    Integer right = 0;
                    String temp = "";
                    if(length2%2 != 0) {
                        temp = square.substring(0, length-1);
                        left  = Integer.parseInt(temp.equals("") ? "0" : temp);

                        temp = square.substring(length-1, length2);
                        right = Integer.parseInt(temp.equals("") ? "0" : temp);
                    } else {
                        temp = square.substring(0, length);
                        left  = Integer.parseInt(temp.equals("") ? "0" : temp);

                        temp = square.substring(length, length2);
                        right = Integer.parseInt(temp.equals("") ? "0" : temp);
                    }

                    if(left + right == i) {
                        // System.out.println(left + " -- " + right);

                        System.out.print(i + " ");
                        count++;
                    }
                // }
            }

            if(count == 0) {
                System.out.println("INVALID RANGE");
            }

        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
