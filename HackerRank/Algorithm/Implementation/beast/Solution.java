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
            for (int t = 0; t < test_cases; t++) {
                Integer num = Integer.parseInt(br.readLine());

                Integer num_of_three = 0;
                Integer num_of_five = 0;
                StringBuffer ans = new StringBuffer();

                if(num%3 == 0 && num > 0) {
                    for(int i=0; i< num; i++) {
                        ans.append("5");
                    }
                } else if(num > 2) {
                    while(num%3 != 0) {
                        num_of_three += 5;
                        num -= 5;
                    }

                    num_of_five = num;

                    if(num_of_five < 0) {
                        // System.out.print("-1");
                        ans.append("-1");
                    } else {
                        for(int i = 0; i < num_of_five; i++) {
                            // System.out.print("5");
                            ans.append("5");
                        }

                        for(int i = 0; i < num_of_three; i++) {
                            // System.out.print("3");
                            ans.append("3");
                        }
                    }

                } else {
                    ans.append("-1");
                }

                System.out.println(ans);
                // System.out.println("");
            }
        } catch(Exception e) {

        }
    }
}
