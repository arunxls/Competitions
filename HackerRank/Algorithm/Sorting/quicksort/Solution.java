import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution {
    static int[] array;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            array = new int[Integer.parseInt(br.readLine())];
            int count = 0;
            for(String s: br.readLine().split(" ")) {
                array[count++] = Integer.parseInt(s);
            }

            quickSort(0, array.length-1);

            for(int a: array) {
                System.out.println(a);
            }

        } catch(Exception e) {
            System.err.println(e);
        }
    }

    static void quickSort(int left, int right) {
        int pivot = array[(left + right)/2];
        int i = left;
        int j = right;

        while(i <= j) {
            while(array[i] < pivot) {
                i++;
            }

            while(array[j] > pivot) {
                j--;
            }

            if(i <= j) {
                int temp = array[i];
                array[i]     = array[j];
                array[j]     = temp;
            }
        }

        if(left < i) {
            quickSort(left, i);
        }

        if(right > j) {
            quickSort(right, j);
        }
    }

    static void partition() {

    }
}