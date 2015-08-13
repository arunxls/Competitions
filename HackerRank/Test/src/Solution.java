import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] params = br.readLine().split(" ");
            Integer n = Integer.parseInt(params[0]);
            Integer m = Integer.parseInt(params[1]);
            Integer k = Integer.parseInt(params[2]);

            String[][] a = new String[n][m];
            Integer x = 0;
            Integer y = 0;
            for(int i = 0; i < n; i++) {
                String[] temp = br.readLine().split("");
                for(int j = 0; j < m; j++) {
                    a[i][j] = temp[j];
                    if(temp[j].equals("*")) {
                        x = i; y = j;
                    }
                }
            }

            int[][][] f = new int[k+1][n][m];

            Integer inf = 1 << 28;

            for(int l = 0; l <= k; l++) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(l == 0) {
                            f[l][i][j] = (i ==0 && j==0) ? 0 : inf;
                        } else {
                            f[l][i][j] = inf;
                            if(i > 0) f[l][i][j]   = Math.min(f[l][i][j], f[l-1][i-1][j] + (a[i-1][j].equals("D") ? 0 : 1 ));
                            if(i < n-1) f[l][i][j] = Math.min(f[l][i][j], f[l-1][i+1][j] + (a[i+1][j].equals("U") ? 0 : 1 ));
                            if(j > 0) f[l][i][j]   = Math.min(f[l][i][j], f[l-1][i][j-1] + (a[i][j-1].equals("R") ? 0 : 1 ));
                            if(j < m-1) f[l][i][j] = Math.min(f[l][i][j], f[l-1][i][j+1] + (a[i][j+1].equals("L") ? 0 : 1 ));
                        }
                    }
                }
            }

            Integer min = inf;
            for(int i = 0; i <= k; i++) {
                min = Math.min(min, f[i][x][y]);
            }

            if(min >= inf) {
                System.out.println(-1);
            } else {
                System.out.println(min);
            }

        } catch(Exception e) {
            System.err.println(e);
        }
    }
}