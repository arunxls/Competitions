import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer num = Integer.parseInt(br.readLine());
			HashMap<Integer, ArrayList<Integer>> times = new HashMap<Integer, ArrayList<Integer>>();
			int index = 1;
			for(int i = 0; i < num; i++) {
				String[] o = br.readLine().split(" ");
				int t = Integer.parseInt(o[0]);
				int d = Integer.parseInt(o[1]);

				if(times.get(t+d) == null) {
					times.put(t+d, new ArrayList<Integer>());
				}
				times.get(t+d).add(index);
				index++;
			}

			ArrayList<Integer> key_set = new ArrayList<Integer>(times.keySet());
			Collections.sort(key_set);

			for(int i: key_set) {
				for(int j: times.get(i)) {
					System.out.print(j + " ");
				}
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}