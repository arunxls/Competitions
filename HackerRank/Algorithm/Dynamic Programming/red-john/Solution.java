import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static Long[] change;
    public static Integer[] bricks;
    public static long one = (long) 1;
    public static long zero = (long) 0;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                Long total = Long.parseLong(br.readLine());
                bricks = new Integer[2];
                bricks[0] = 1;
                bricks[1] = 4;

                change = new Long[total.intValue()+1];

//                for(int i = 0; i <= total; i++) {
//                    change[i] = zero;
//                }

                change[0] = one;
                change[bricks[0]] = one;


                // for(Integer b: bricks) {
                //     for(int i = 1; i <= total; i++) {
                //         if(b <= i) {
                //             matrix[i] = matrix[i] + matrix[b-i];
                //         }
                //     }
                // }

                Long ans = getChange(total);
                if(ans.intValue() == 1) {
                    System.out.println(0);
                } else {
                    long primes = (long) 0;
                    Long[] p = new Long[ans.intValue() + 1];
                    for(long i = 2; i <= ans; i++) {
                        if(p[(int)i] == null) {
                            primes++;
                            for(long j = i; j <= ans; j += i) {
                                p[(int) j] = (long) 0;
                            }
                        }
                    }
                    System.out.println(primes);
                }
            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }

    public static long getChange(Long n) {
        if(n.intValue() < 0) {
            return 0;
        } else if (change[n.intValue()] == null) {
            change[n.intValue()] = getChange(n-bricks[0]) + getChange(n-bricks[1]);
        }

        return change[n.intValue()];
    }
}