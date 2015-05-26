import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
	
class Solution {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer test_cases = Integer.parseInt(br.readLine());
			for(int i = 0; i < test_cases; i++) {
				Integer rows = Integer.parseInt(br.readLine());
				Integer cols = null;
				ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>();
				for (int j = 0; j < rows; j++) {
					String s = br.readLine();
					ArrayList<Character> r = new ArrayList<Character>();
					for(Character c : s.toCharArray()) {
						r.add(c);
					}

					Collections.sort(r);
					cols = r.size();
					grid.add(r);
				}

				Boolean flag = true;
				for(int j = 0; j < cols; j++) {
					Character c = grid.get(0).get(j);
					for(int k = 0; k < rows; k++) {
						if(Character.compare(c, grid.get(k).get(j)) > 0) {
							flag = false;
						} else {
							flag &= true;
						}
					}
				}

				if(flag) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}

			}



		} catch (Exception e) {
			System.err.println(e);
		}
	}
}