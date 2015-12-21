import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Node {
    TreeNode node;
    int height;

    Node(TreeNode n, int h) { this.node = n; this.height = h;}
}

public class Solution {
    public static void main(String[] args) {
        String[] foo = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(isAdditiveNumber("199100199"));
        System.out.print("");
    }

    public static boolean isAdditiveNumber(String num) {
        int n = num.length();

        for(int i = 1; i <= n/2; i++) {
            for(int j = 1; i + j < n; j++) {
                if(isValid(i, j, num)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValid(int i, int j, String num) {
        if (num.charAt(i) == '0' && j > 1) return false;
        if(num.charAt(0) == '0' && i > 1) return false;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        String sum;
        for(int start = i + j; start < num.length(); start += sum.length()) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            sum = x2.toString();
            if(!num.startsWith(sum, start)) {
                return false;
            }
        }

        return true;
    }
}