import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// https://www.hackerrank.com/challenges/cut-the-sticks

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        try{
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	
        	Integer num = Integer.parseInt(br.readLine());
        	String[] input = br.readLine().split(" ");
        	ArrayList<Integer> in_array = new ArrayList<Integer>();
        	for(String s: input) {
        		in_array.add(Integer.parseInt(s));
        	}

        	Boolean flag = true;
        	while(flag) {
        		//Find min
        		Integer min = null;
        		for(Integer x: in_array) {
        			if(min == null || x < min) {
        				min = x;
        			}
        		}

        		//Subtract min value
        		int count = in_array.size();
        		int reduction = 0;
				for(int x = 0; x < in_array.size(); x++) {
					in_array.set(x, in_array.get(x) - min);
					if(in_array.get(x) == 0) {
						reduction++;
					}
				}

				//Array compaction
				while(reduction > 0) {
					in_array.remove(new Integer(0));
					reduction--;	
				}

				if(count > 0) {
					System.out.println(count);	
				}
        		flag = count > 0;
        	}

        } catch (Exception e) {
        	System.err.println(e);
        }

    }
}