import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] params = br.readine().split(" ");
            Integer row = Integer.parseInt(params[0]);
            Integer column = Integer.parseInt(params[1]);
            Integer rotate = Integer.parseInt(params[2]);

            String[][] matrix = new String[row][column];


        } catch(Exception e) {
            System.err.println(e);
        }
    }
}