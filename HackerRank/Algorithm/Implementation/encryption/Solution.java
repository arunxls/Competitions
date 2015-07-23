import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split("");
            Integer length = input.length;



            Integer row = (int) Math.floor(Math.sqrt(length));
            Integer column = (int) Math.ceil(Math.sqrt(length));
            row = column;

            String[][] matrix = new String[row][column];
            Integer count = 0;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < column; j++) {
                    matrix[i][j] = "";
                }
            }

            for(int i = 0; i < row; i++) {
                if(length == count) {
                    break;
                }
                for(int j = 0; j < column; j++) {
                    if(length == count) {
                        break;
                    }
                    matrix[i][j] = input[count];
                    count++;
                }
            }

            for(int i = 0; i < column; i++) {
                for(int j = 0; j < row; j++) {
                    System.out.print(matrix[j][i]);
                }
                System.out.print(" ");
            }


        } catch (Exception e) {
            System.err.println(e);
        }
    }
}