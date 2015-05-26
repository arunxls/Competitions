import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] num = br.readLine().split(" ");

			int num_friends = Integer.parseInt(num[1]);
			int num_flowers = Integer.parseInt(num[0]);
			
			ArrayList<Integer> cost = new ArrayList<Integer>();
			for(String s: br.readLine().split(" ")) {
				cost.add(Integer.parseInt(s));
			}
			
			//Sort reverse
			Collections.sort(cost, Collections.reverseOrder());
			ArrayList<buddy> friends = new ArrayList<buddy>();
			for(int i = 0; i < num_friends; i++) {
				friends.add(new buddy());
			}
		
			int index = 0;
			while(cost.size() > 0) {
				int flower_cost = cost.get(0);
				cost.remove(0);
				friends.get(index%num_friends).flowers.add(flower_cost);
				index++;
			}			

			Integer total_cost = 0;
			for(buddy b: friends) {
				total_cost += b.cost();
			}

			System.out.print(total_cost);

			// for(int i: cost) {
			// 	System.out.println(i);
			// }

		} catch(Exception e) {
			System.err.println(e);
		}
	}
}

class buddy {
	public ArrayList<Integer> flowers;

	buddy() {
		flowers = new ArrayList<Integer>();
	}

	public int cost() {
		int mult = 1;
		int total_cost = 0;
		for(int i : flowers) {
			total_cost += mult*i;
			mult++;
		}

		return total_cost;
	}
}