import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            Integer[] array = new Integer[N];

            for(int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(temp[i]);
            }

            Integer pivot = array[0];
            for(int i = 1; i < N; i++) {
                if(array[i] < pivot) {
                    System.out.print(array[i] + " ");
                }
            }

            System.out.print(pivot + " ");

            for(int i = 1; i < N; i++) {
                if(array[i] > pivot) {
                    System.out.print(array[i] + " ");
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}