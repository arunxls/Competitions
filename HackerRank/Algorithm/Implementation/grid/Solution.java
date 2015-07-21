import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for (int t = 0; t < test_cases; t++) {
                String[] params_main = br.readLine().split(" ");

                Integer rows_main = Integer.parseInt(params_main[0]);
                String[] orig_matrix = new String[rows_main];
                for(int i = 0; i < rows_main; i++) {
                    orig_matrix[i] = br.readLine();
                }

                String[] params_aux = br.readLine().split(" ");

                Integer rows_aux = Integer.parseInt(params_aux[0]);
                String[] aux_matrix = new String[rows_aux];
                for(int i = 0; i < rows_aux; i++) {
                    aux_matrix[i] = br.readLine();
                }

                if(match(orig_matrix, aux_matrix)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static boolean match(String[] main_matrix, String[] aux_matrix) {
        String check = aux_matrix[0];
        String regex = ".*";
        Integer start_index = -1;
        for(int k = 0; k < main_matrix.length; k++) {
            if(main_matrix[k].matches(regex+check+regex)) {
                start_index = k;
                String[] main_chars = main_matrix[start_index].split("");
                String[] aux_chars = aux_matrix[0].split("");

                int check_index = 0;
                for(int i = 0; i < main_chars.length; i++) {
                    if(main_chars[i].equals(aux_chars[0])) {
                        check_index = i;
                        Boolean flag = true;
                        for(int j = 0; j < aux_chars.length; j++) {
                            if(!main_chars[i + j].equals(aux_chars[j])) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) {
                            break;
                        }
                    }
                }

                Boolean flag = true;
                for(int i = 0; i < aux_matrix.length; i++) {
                    if(!main_matrix[start_index++].substring(check_index, check_index + aux_matrix[0].length()).matches(regex+aux_matrix[i]+regex)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    return true;
                }
            }
        }

        return false;
    }
}