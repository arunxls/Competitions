import java.lang.*;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> num_to_string = new HashMap<Integer, String>();

        num_to_string.put(1, "one");
        num_to_string.put(2, "two");
        num_to_string.put(3, "three");
        num_to_string.put(4, "four");
        num_to_string.put(5, "five");
        num_to_string.put(6, "six");
        num_to_string.put(7, "seven");
        num_to_string.put(8, "eight");
        num_to_string.put(9, "nine");
        num_to_string.put(10, "ten");
        num_to_string.put(11, "eleven");
        num_to_string.put(12, "twelve");
        num_to_string.put(13, "thirteen");
        num_to_string.put(14, "fourteen");
        num_to_string.put(15, "fifteen");
        num_to_string.put(16, "sixteen");
        num_to_string.put(17, "seventeen");
        num_to_string.put(18, "eighteen");
        num_to_string.put(19, "nineteen");
        num_to_string.put(20, "twenty");
        num_to_string.put(21, "twenty one");
        num_to_string.put(22, "twenty two");
        num_to_string.put(23, "twenty three");
        num_to_string.put(24, "twenty four");
        num_to_string.put(25, "twenty five");
        num_to_string.put(26, "twenty six");
        num_to_string.put(27, "twenty seven");
        num_to_string.put(28, "twenty eight");
        num_to_string.put(29, "twenty nine");

        try {
            Integer hour = Integer.parseInt(br.readLine());
            Integer min  = Integer.parseInt(br.readLine());
            Integer next_hour = new Integer(0);
            if(hour < 12) {
                next_hour = hour + 1;
            } else {
                next_hour = 1;
            }

            if(min == 30) {
                System.out.println("half past " + num_to_string.get(hour));
            } else if(min == 0) {
                System.out.println(num_to_string.get(hour) + " o' clock");
            } else if (min == 1) {
                System.out.println(num_to_string.get(min) + " minute past " + num_to_string.get(hour));
            } else if (min == 15) {
                System.out.println("quarter past " + num_to_string.get(hour));
            } else if (min < 30) {
                System.out.println(num_to_string.get(min) + " minutes past " + num_to_string.get(hour));
            } else if(min == 45) {
                System.out.println("quarter to " + num_to_string.get(next_hour));
            } else if(min == 59) {
                System.out.println("one minute to " + num_to_string.get(next_hour));
            } else if(min > 30) {
                System.out.println(num_to_string.get(60-min) + " minutes to " + num_to_string.get(next_hour));
            }

        } catch(Exception e) {

        }
    }
}