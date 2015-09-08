import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                String[] params = br.readLine().split(" ");
                Integer L = Integer.parseInt(params[0]);
                String[] A  = params[1].split("");
                String[] B  = params[2].split("");

                ArrayList<Cell> zeros = new ArrayList<>();

                Cell[][] diff = new Cell[A.length][A.length];
                for(int i = 0; i < A.length; i++) {
                    for(int j = 0; j < B.length; j++) {
                        if(A[i].equals(B[j])) {
                            diff[i][j] = new Cell(i, j, 0);
                            zeros.add(diff[i][j]);
                        } else {
                            diff[i][j] = new Cell(i, j, 1);
                        }
                    }
                }

                for(int i = 0; i < zeros.size(); i++) {
                    Cell cell = zeros.get(i);


                }

                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class Cell {
    public int x;
    public int y;
    public int value;

    Cell (int x, int y, value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}