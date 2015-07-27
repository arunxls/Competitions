import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Integer test_cases = Integer.parseInt(br.readLine());
            for(int t = 0; t < test_cases; t++) {
                HashMap<Integer, Integer> short_cuts = new HashMap<Integer, Integer>();
                Integer ladders = Integer.parseInt(br.readLine());
                for(int i = 0; i < ladders; i++) {
                    String[] params = br.readLine().split(" ");
                    Integer start = Integer.parseInt(params[0]);
                    Integer end   = Integer.parseInt(params[1]);
                    short_cuts.put(start, end);
                }

                Integer snakes = Integer.parseInt(br.readLine());
                for(int i = 0; i < snakes; i++) {
                    String[] params = br.readLine().split(" ");
                    Integer start = Integer.parseInt(params[0]);
                    Integer end   = Integer.parseInt(params[1]);
                    short_cuts.put(start, end);
                }

                ArrayList<Integer> fringe = new ArrayList<Integer>();
                HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();


                fringe.add(1);
                distance.put(1, 0);
                while(fringe.size() > 0) {
                    Integer current_index = fringe.get(0);
                    fringe.remove(0);
                    Integer current_distance = distance.get(current_index);

                    if(current_index == 100) {
                        System.out.println(current_distance);
                        break;
                    } else if(current_index > 100) {
                        continue;
                    } else {
                        for(int i = current_index + 1; i < current_index + 7; i++) {
                            if(short_cuts.containsKey(i)) {
                                if(!distance.containsKey(i)) {
                                    fringe.add(short_cuts.get(i));
                                    distance.put(short_cuts.get(i), current_distance + 1);
                                }
                            } else if(!distance.containsKey(i)) {
                                fringe.add(i);
                                distance.put(i, current_distance + 1);
                            }
                        }
                    }
                }

                if(fringe.size() == 0) {
                    System.out.println(-1);
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}