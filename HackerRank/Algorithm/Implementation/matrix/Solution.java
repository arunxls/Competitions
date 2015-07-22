import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] params = br.readLine().split(" ");
            Integer row = Integer.parseInt(params[0]);
            Integer column = Integer.parseInt(params[1]);
            Integer rotate = Integer.parseInt(params[2]);

            String[][] matrix = new String[row][column];
            for(int t = 0; t < row; t++) {
                String[] temp = br.readLine().split(" ");
                for(int s = 0; s < column; s++) {
                    matrix[t][s] = temp[s];
                }
            }

            ArrayList<ArrayList<String>> normalized = new ArrayList<ArrayList<String>>();

            Integer limit = (int) Math.ceil(((float) column)/((float) 2));
            System.out.println(limit);
            for(int i = 0; i < limit; i++) {
                normalized.add(norm(matrix, i));
            }

            // ArrayList<Integer> offsets = new ArrayList<Integer>();
            // for(ArrayList<String> a: normalized) {
            //     Integer len = a.size();
            //     offsets.add((len+rotate)%len);
            // }

            // // for(Integer x: offsets) {
            // //     System.out.println(x);
            // // }

            // String[][] new_matrix = get_rotated(normalized, offsets, row, column);

            // for(int t = 0; t < row; t++) {
            //     for(int s = 0; s < column; s++) {
            //         System.out.print(new_matrix[t][s] + " ");
            //     }
            //     System.out.println("");
            // }


            // for(ArrayList<String> a: normalized) {
            //     for (String s: a) {
            //         System.out.print(s + " ");
            //     }
            //     System.out.println("");
            // }

        } catch(Exception e) {
            System.err.println(e);
        }
    }

    public static String[][] get_rotated(ArrayList<ArrayList<String>> normalized, ArrayList<Integer> offsets, Integer row, Integer column) {
        String[][] matrix = new String[row][column];

        Integer limit = (int) Math.ceil(((float) column)/((float) 2));
        for(int j = 0; j < limit; j++) {
            ArrayList<String> nums = normalized.get(j);
            Integer len = nums.size();
            Integer offset = offsets.get(j);
            for(int i = j; i < column-j; i++) {
                matrix[j][i] = nums.get((offset)%len);
                offset++;
            }

            for(int i = j+1; i < row-j; i++) {
                matrix[i][column-j-1] = nums.get((offset)%len);
                offset++;
            }

            for(int i = column-j-2; i >= j; i--) {
                matrix[row-j-1][i] = nums.get((offset)%len);
                offset++;
            }

            for(int i = row-j-2; i > j; i--) {
                matrix[i][j] = nums.get((offset)%len);
                offset++;
            }
        }



        return matrix;
    }

    public static ArrayList<String> norm(String[][] matrix, Integer offset) {
        ArrayList<String> temp = new ArrayList<String>();
        Integer row            = matrix.length;
        Integer column         = matrix[0].length;

        //        1
        //     ________
        //    |        |
        //  4 |        | 2
        //    |        |
        //     --------
        //        3
        // Add the elements in the order 1,2,3,4

        for(int i = offset; i < column-offset; i++) {
            System.out.println(offset);
            temp.add(matrix[offset][i]);
        }

        // for(int i = offset+1; i < row-offset; i++) {
        //     temp.add(matrix[i][column-offset-1]);
        // }

        // for(int i = column-offset-2; i >= offset; i--) {
        //     temp.add(matrix[row-offset-1][i]);
        // }

        // for(int i = row-offset-2; i > offset; i--) {
        //     temp.add(matrix[i][offset]);
        // }

        return temp;
    }
}