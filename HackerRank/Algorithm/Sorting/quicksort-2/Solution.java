import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    static Integer[] array;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            array = new Integer[N];

            for(int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(temp[i]);
            }

            Integer pivot = array[0];
            partition(0, N-1);

            System.out.println(" ");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void partition(int start, int end) {
        if(start - end == 0) {
            return;
        } else {
            int pivot = array[0 + start];
            int pivot_position = 0 + start;
            for(int i = start + 1; i < end; i++) {
                if(array[i] < pivot) {
                    swap(array[0 + start], i);
                    pivot_position = i;
                } else {
                    swap(array[end], i);
                }
            }

            partition(0, pivot_position);
            partition(pivot_position+1, end);
        }
    }

    public static void swap(int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}