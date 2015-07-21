import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];

            for(int t = 0; t < size; t++) {
                String[] params = br.readLine().split("");
                for (int i = 0; i < size; i++) {
                    matrix[t][i] = Integer.parseInt(params[i]);
                }
            }

            for(int i = 1; i < size - 1; i++) {
                for(int j = 1; j < size - 1; j++) {
                    Integer check = matrix[i][j];
                    // System.out.println("Checking " + check);

                    if(   check > matrix[i-1][j]
                       && check > matrix[i][j-1]
                       && check > matrix[i][j+1]
                       && check > matrix[i+1][j]
                    ) {
                        // System.out.println("TRUE");
                        matrix[i][j] = 12;
                    }
                }
            }

            for(int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(matrix[i][j] == 12) {
                        System.out.print("X");
                    } else {
                        System.out.print(matrix[i][j]);
                    }
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}