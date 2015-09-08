import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                Integer N = Integer.parseInt(br.readLine());
                int[][] grid = new int[2][N];
                boolean first = true;
                Integer x = 0;
                Integer y = 0;
                Integer count = 0;
                for(int i = 0; i < 2; i++) {
                    String[] cells = br.readLine().split("");
                    for(int j = 0; j < N; j++) {
                        grid[i][j] = Integer.parseInt(cells[j]);
                        if(grid[i][j] == 1) {
                            count++;
                            if(first){
                                first = false;
                                x = i; y = j;
                            }
                        }
                    }
                }

                if(count%2 != 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }



            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}